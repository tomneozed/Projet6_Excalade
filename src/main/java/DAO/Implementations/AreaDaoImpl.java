package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import beans.Area;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl implements AreaDao
{
    private DaoFactory daoFactory;
    private Connection connexion;

    public AreaDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public void add(Area area) {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.area(name, route_count, type, description, site_id) " +
                            "VALUES(?,?,?,?,?);");

            preparedStatement.setString(1, area.getName());
            preparedStatement.setInt(2, area.getRoute_count());
            preparedStatement.setString(3, area.getType());
            preparedStatement.setString(4, area.getDescription());
            preparedStatement.setInt(5, area.getSite_id());

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
                    "DELETE FROM public.area WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void update(int id, Area newArea)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "UPDATE public.area " +
                            "SET name = ?, " +
                            "route_count = ?, " +
                            "type = ?," +
                            "description = ?," +
                            "site_id = ?" +
                            "WHERE id = ?;");
            preparedStatement.setString(1, newArea.getName());
            preparedStatement.setInt(2, newArea.getRoute_count());
            preparedStatement.setString(3, newArea.getType());
            preparedStatement.setString(4, newArea.getDescription());
            preparedStatement.setInt(5, newArea.getSite_id());

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public List<Area> list()
    {
        List<Area> areaList = new ArrayList<Area>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, name, route_count, type, description, site_id FROM public.area;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                String name = resultat.getString("name");
                int route_count = resultat.getInt("route_count");
                String type = resultat.getString("type");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");

                Area area = new Area(id, name, route_count, type, description, site_id);

                areaList.add(area);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return areaList;
    }

    public Area find(int id)
    {
        Area area = new Area();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT name, route_count, type, description, site_id FROM public.area WHERE id="+ id +";");
            while (resultat.next())
            {
                String name = resultat.getString("name");
                int route_count = resultat.getInt("route_count");
                String type = resultat.getString("type");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");

                area.setId(id);
                area.setName(name);
                area.setRoute_count(route_count);
                area.setType(type);
                area.setDescription(description);
                area.setSite_id(site_id);
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return area;
    }
}
