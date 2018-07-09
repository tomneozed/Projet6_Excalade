package DAO.Interfaces;

import beans.Route;

import java.util.List;

public interface RouteDao {
    int add(Route route);

    void delete(int id);

    void update(int id, Route newRoute);

    List<Route> list();

    List<Route> listByArea(int areaId);

    List<Route> listByArea(int areaId, int ownerId);

    Route find(int id);
}
