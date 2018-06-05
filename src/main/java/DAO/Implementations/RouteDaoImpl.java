package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.RouteDao;
import beans.Area;
import beans.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao
{
    private DaoFactory daoFactory;
    private Connection connexion;

    public RouteDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public void add(Route route)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.route(area_id, route_number, height, grade, anchor_count)" +
                            "VALUES(?,?,?,?,?);");
            preparedStatement.setInt(1, route.getArea_id());
            preparedStatement.setInt(2, route.getRoute_number());
            preparedStatement.setFloat(3, route.getHeight());
            preparedStatement.setString(4, route.getGrade());
            preparedStatement.setInt(5, route.getAnchor_count());

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
                    "DELETE FROM public.route WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(int id, Route newRoute)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "UPDATE public.route " +
                            "SET area_id = ?, " +
                            "route_number = ?, " +
                            "height = ?, " +
                            "grade = ?, " +
                            "anchor_count = ? " +
                            "WHERE id = ?;");

            preparedStatement.setInt(1, newRoute.getArea_id());
            preparedStatement.setInt(2, newRoute.getRoute_number());
            preparedStatement.setFloat(3, newRoute.getHeight());
            preparedStatement.setString(4, newRoute.getGrade());
            preparedStatement.setInt(5, newRoute.getAnchor_count());

            preparedStatement.executeUpdate();

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Route> list()
    {
        List<Route> routeList = new ArrayList<Route>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.route;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int area_id = resultat.getInt("area_id");
                int route_number = resultat.getInt("route_number");
                float height = resultat.getFloat("height");
                String grade = resultat.getString("grade");
                int anchor_count = resultat.getInt("anchor_count");

                Route route = new Route(id, area_id, route_number, height, grade, anchor_count);

                routeList.add(route);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return routeList;
    }

    public List<Route> listByArea(int areaId) {
        List<Route> routeListByArea = new ArrayList<Route>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM route WHERE area_id = " + areaId + ";");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int area_id = resultat.getInt("area_id");
                int route_number = resultat.getInt("route_number");
                float height = resultat.getFloat("height");
                String grade = resultat.getString("grade");
                int anchor_count = resultat.getInt("anchor_count");

                Route route = new Route(id, area_id, route_number, height, grade, anchor_count);

                routeListByArea.add(route);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return routeListByArea;
    }

    public Route find(int id)
    {
        Route route  = new Route();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT * FROM public.route WHERE id="+ id +";");
            while (resultat.next())
            {
                int area_id = resultat.getInt("area_id");
                int route_number = resultat.getInt("route_number");
                float height = resultat.getFloat("height");
                String grade = resultat.getString("grade");
                int anchor_count = resultat.getInt("anchor_count");

                route.setId(id);
                route.setArea_id(area_id);
                route.setRoute_number(route_number);
                route.setHeight(height);
                route.setGrade(grade);
                route.setAnchor_count(anchor_count);
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return route;
    }
}
