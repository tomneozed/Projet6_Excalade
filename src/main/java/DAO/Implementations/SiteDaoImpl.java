package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.SiteDao;
import beans.Site;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteDaoImpl implements SiteDao
{
    private DaoFactory daoFactory;
    Connection connexion;

    public SiteDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public void add(Site site)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.site(owner_id, state, county, region, name, add_day)" +
                            "VALUES(?,?,?,?,?,?);");
            preparedStatement.setInt(1, site.getOwner_id());
            preparedStatement.setString(2, site.getState());
            preparedStatement.setString(3, site.getCounty());
            preparedStatement.setString(4, site.getRegion());
            preparedStatement.setString(5, site.getName());
            preparedStatement.setString(6, site.getAdd_day());

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "DELETE FROM public.site WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(int id, Site newSite)
    {
        PreparedStatement preparedStatement;

        try
        {
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

            preparedStatement.setInt(1, newSite.getOwner_id());
            preparedStatement.setString(2, newSite.getState());
            preparedStatement.setString(3, newSite.getCounty());
            preparedStatement.setString(4, newSite.getRegion());
            preparedStatement.setString(5, newSite.getName());
            preparedStatement.setString(6, newSite.getAdd_day());

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Site> list()
    {
        List<Site> siteList = new ArrayList<Site>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, owner_id, state, county, region, name, add_day FROM public.site;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int owner_id = resultat.getInt("owner_id");
                String state = resultat.getString("state");
                String county = resultat.getString("county");
                String region = resultat.getString("region");
                String name = resultat.getString("name");
                String add_day = resultat.getString("add_day");

                Site person = new Site(id, owner_id, state, county, region, name, add_day);

                siteList.add(person);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return siteList;
    }

    public Site find(int id)
    {
        Site site = new Site();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT owner_id, state, county, region, name, add_day FROM public.site WHERE id="+ id +";");
            while (resultat.next())
            {
                int owner_id = resultat.getInt("owner_id");
                String state = resultat.getString("state");
                String county = resultat.getString("county");
                String region = resultat.getString("region");
                String name = resultat.getString("name");
                String add_day = resultat.getString("add_day");

                site.setId(id);
                site.setOwner_id(owner_id);
                site.setState(state);
                site.setCounty(county);
                site.setRegion(region);
                site.setName(name);
                site.setAdd_day(add_day);
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return site;
    }
}
