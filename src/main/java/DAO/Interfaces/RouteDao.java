package DAO.Interfaces;

import beans.Route;

import java.util.List;

public interface RouteDao
{
    void add(Route route);

    void delete(int id);

    void update(int id, Route newRoute);

    List<Route> list();

    Route find(int id);
}
