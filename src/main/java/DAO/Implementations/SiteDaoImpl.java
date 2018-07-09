package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.ReservationsGuidebookDao;
import DAO.Interfaces.SiteDao;
import beans.Area;
import beans.ReservationsGuidebook;
import beans.Site;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SiteDaoImpl implements SiteDao {
    private DaoFactory daoFactory;
    Connection connexion;

    public SiteDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public int add(Site site) {
        PreparedStatement preparedStatement;
        int siteId = -1;
        try {
            //String to Date conversion
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date date = sdf1.parse(site.getAddDay());
            java.sql.Date addDate = new java.sql.Date(date.getTime());

            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                "INSERT INTO public.site(owner_id, state, county, region, name, add_day)" +
                    "VALUES(?,?,?,?,?,?::date);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, site.getOwnerId());
            preparedStatement.setString(2, site.getState());
            preparedStatement.setString(3, site.getCounty());
            preparedStatement.setString(4, site.getRegion());
            preparedStatement.setString(5, site.getName());
            preparedStatement.setDate(6, addDate);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                siteId = rs.getInt(1);
            }

            System.out.println("[add] SiteId : " + siteId);
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return siteId;
    }

    public void delete(int id) {
        AreaDao areaDao = daoFactory.getAreaDao();
        List<Area> areasToDelete = areaDao.listBySite(id);
        ReservationsGuidebookDao reservationDao = daoFactory.getReservationDao();
        List<ReservationsGuidebook> reservationsToDelete = reservationDao.listBySite(id);
        PreparedStatement preparedStatement;

        try {
            if (!areasToDelete.isEmpty()) {
                for (int i = 0; i < areasToDelete.size(); i++) {
                    areaDao.delete(areasToDelete.get(i).getId());
                }
            }
            if (!reservationsToDelete.isEmpty()) {
                for (int i = 0; i < reservationsToDelete.size(); i++) {
                    reservationDao.delete(reservationsToDelete.get(i).getId());
                }
            }

            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                "DELETE FROM public.site WHERE id = ?;");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Site newSite) {
        PreparedStatement preparedStatement;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                "UPDATE public.site " +
                    "SET owner_id = ?, " +
                    "state = ?, " +
                    "county = ?, " +
                    "region = ?, " +
                    "name = ?, " +
                    "add_day = ? " +
                    "WHERE id = ?;");

            preparedStatement.setInt(1, newSite.getOwnerId());
            preparedStatement.setString(2, newSite.getState());
            preparedStatement.setString(3, newSite.getCounty());
            preparedStatement.setString(4, newSite.getRegion());
            preparedStatement.setString(5, newSite.getName());
            preparedStatement.setString(6, newSite.getAddDay());

            preparedStatement.executeUpdate();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Site> list() {
        List<Site> siteList = new ArrayList<Site>();

        AreaDao areaDao = daoFactory.getAreaDao();
        Statement statement;
        ResultSet resultat;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.site;");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                int owner_id = resultat.getInt("owner_id");
                String state = resultat.getString("state");
                String county = resultat.getString("county");
                String region = resultat.getString("region");
                String name = resultat.getString("name");
                String add_day = resultat.getString("add_day");

                Site site = new Site();
                site.setId(id);
                site.setOwnerId(owner_id);
                site.setAddDay(add_day);
                site.setCounty(county);
                site.setName(name);
                site.setRegion(region);
                site.setState(state);

                List<Area> areaListBySite = areaDao.listBySite(id);

                site.setAreaList(areaListBySite);

                siteList.add(site);
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteList;
    }

    public List<Site> researchList(String researchInput) {
        List<Site> siteList = new ArrayList<Site>();

        AreaDao areaDao = daoFactory.getAreaDao();
        Statement statement;
        ResultSet resultat;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.site WHERE " +
                "(state LIKE '%" + researchInput + "%') OR" +
                "(county LIKE '%" + researchInput + "%') OR" +
                "(region LIKE '%" + researchInput + "%') OR" +
                "(name LIKE '%" + researchInput + "%');");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                int owner_id = resultat.getInt("owner_id");
                String state = resultat.getString("state");
                String county = resultat.getString("county");
                String region = resultat.getString("region");
                String name = resultat.getString("name");
                String add_day = resultat.getString("add_day");

                Site site = new Site();
                site.setId(id);
                site.setOwnerId(owner_id);
                site.setAddDay(add_day);
                site.setCounty(county);
                site.setName(name);
                site.setRegion(region);
                site.setState(state);

                List<Area> areaListBySite = areaDao.listBySite(id);

                site.setAreaList(areaListBySite);

                siteList.add(site);
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteList;
    }

    public Site find(int id) {
        Site site = new Site();
        AreaDao areaDao = daoFactory.getAreaDao();
        Statement statement;
        ResultSet resultat;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                "SELECT * FROM public.site WHERE id=" + id + ";");
            while (resultat.next()) {
                int owner_id = resultat.getInt("owner_id");
                String state = resultat.getString("state");
                String county = resultat.getString("county");
                String region = resultat.getString("region");
                String name = resultat.getString("name");
                String add_day = resultat.getString("add_day");

                site.setId(id);
                site.setOwnerId(owner_id);
                site.setState(state);
                site.setCounty(county);
                site.setRegion(region);
                site.setName(name);
                site.setAddDay(add_day);

                List<Area> areaListBySite = areaDao.listBySite(id);

                site.setAreaList(areaListBySite);
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return site;
    }

    public int findOwnerId(int siteId) {
        int ownerId = -1;
        Statement statement;
        ResultSet resultat;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                "SELECT owner_id FROM public.site WHERE id=" + siteId + ";");
            while (resultat.next()) {
                ownerId = resultat.getInt("owner_id");
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerId;
    }
}
