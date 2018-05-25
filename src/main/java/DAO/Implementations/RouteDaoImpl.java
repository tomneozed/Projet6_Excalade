package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.RouteDao;
import beans.Route;

import java.sql.Connection;
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

    }

    public void delete(int id)
    {

    }

    public void update(int id, Route newRoute)
    {

    }

    public List<Route> list()
    {
        return null;
    }

    public Route find(int id)
    {
        return null;
    }
}
