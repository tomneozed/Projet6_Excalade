package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.RouteDao;
import DAO.Interfaces.SiteDao;
import beans.Area;
import beans.Comment;
import beans.Route;

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

    public int add(Area area) {
        PreparedStatement preparedStatement;
        int areaId = -1;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.area(name, route_count, type, description, site_id) " +
                            "VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, area.getName());
            preparedStatement.setInt(2, area.getRouteCount());
            preparedStatement.setString(3, area.getType());
            preparedStatement.setString(4, area.getDescription());
            preparedStatement.setInt(5, area.getSiteId());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next())
            {
                areaId = rs.getInt(1);
            }

            System.out.println("[add] AreaId : " + areaId);
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return areaId;
    }

    public void delete(int id)
    {
        RouteDao routeDao = daoFactory.getRouteDao();
        List<Route> routesToDelete = routeDao.listByArea(id);
        CommentDao commentDao = daoFactory.getCommentDao();
        List<Comment> commentsToDelete = commentDao.listByArea(id);

        PreparedStatement preparedStatement;

        try
        {
            if(!routesToDelete.isEmpty())
            {
                for(int i =0; i< routesToDelete.size(); i++)
                {
                    routeDao.delete(routesToDelete.get(i).getId());
                }
            }

            if(!commentsToDelete.isEmpty())
            {
                for(int i =0; i< commentsToDelete.size(); i++)
                {
                    commentDao.delete(commentsToDelete.get(i).getId());
                }
            }

            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "DELETE FROM public.area WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connexion.close();
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
            preparedStatement.setInt(2, newArea.getRouteCount());
            preparedStatement.setString(3, newArea.getType());
            preparedStatement.setString(4, newArea.getDescription());
            preparedStatement.setInt(5, newArea.getSiteId());

            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public List<Area> list()
    {
        List<Area> areaList = new ArrayList<Area>();
        RouteDao routeDao = daoFactory.getRouteDao();
        CommentDao commentDao = daoFactory.getCommentDao();
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

                String type = resultat.getString("type");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");

                List<Route> routeListByArea = routeDao.listByArea(id);

                List<Comment> commentListByArea = commentDao.listByArea(id);

                int route_count = routeListByArea.size();
                System.out.println(route_count);

                Area area = new Area(id, site_id, name, description, type, route_count, routeListByArea, commentListByArea);
                setOwnerId(area);
                areaList.add(area);
                connexion.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return areaList;
    }

    public List<Area> listBySite(int siteId) {
        List<Area> areaListBySite = new ArrayList<Area>();
        RouteDao routeDao = daoFactory.getRouteDao();
        CommentDao commentDao = daoFactory.getCommentDao();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, name, route_count, type, description, site_id " +
                    "FROM public.area " +
                    "WHERE site_id =" + siteId + ";");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                String name = resultat.getString("name");
                int route_count = resultat.getInt("route_count");
                String type = resultat.getString("type");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");

                List<Route> routeListByArea = routeDao.listByArea(id);

                List<Comment> commentListByArea = commentDao.listByArea(id);
                route_count = routeListByArea.size();

                Area area = new Area(id, site_id, name, description, type, route_count, routeListByArea, commentListByArea);
                setOwnerId(area);
                areaListBySite.add(area);
                connexion.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return areaListBySite;
    }

    public Area find(int id)
    {
        Area area = new Area();
        RouteDao routeDao = daoFactory.getRouteDao();
        CommentDao commentDao = daoFactory.getCommentDao();
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


                List<Route> routeListByArea = routeDao.listByArea(id);

                List<Comment> commentListByArea = commentDao.listByArea(id);
                route_count = routeListByArea.size();

                area = new Area(id, site_id, name, description, type, route_count, routeListByArea, commentListByArea);

                setOwnerId(area);
                connexion.close();
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return area;
    }

    /*
    Set the ownerId of the area
     */
    private Area setOwnerId(Area area)
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        SiteDao siteDao = daoFactory.getSiteDao();

        area.setOwnerId(siteDao.find(area.getSiteId()).getOwnerId());

        //LOG System.out.println("[AreaDaoImpl] - setOwnerId() : Owner id : " + area.getOwnerId());

        return area;
    }
}
