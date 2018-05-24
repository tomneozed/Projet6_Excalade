package DAO.Interfaces;

import beans.Site;

import java.util.List;

public interface SiteDao
{
    void add(Site site);

    void delete(int id);

    void update(int id, Site newSite);

    List<Site> list();

    Site find(int id);
}
