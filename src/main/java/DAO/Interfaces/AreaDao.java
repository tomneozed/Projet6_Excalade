package DAO.Interfaces;

import beans.Area;

import java.util.List;

public interface AreaDao
{
    void add(Area area);

    void delete(int id);

    void update(int id, Area newArea);

    List<Area> list();

    List<Area> listBySite(int siteId);

    Area find(int id);
}
