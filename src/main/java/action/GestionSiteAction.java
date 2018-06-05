package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.SiteDao;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GestionSiteAction extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer siteId;

    //- - - - Elements en sortie - - - -

    private List<Site> siteList;
    private Site site;

    //=========  GETTERS & SETTERS  =========

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    //=========  METHODES  =========

    public String doList()
    {
        SiteDao siteDao;
        Site site;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();
        siteList = siteDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        SiteDao siteDao;
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();

        if(siteId == null)
        {
            this.addActionError("Vous devez indiquer un id de site");
        }else
        {
            this.site = siteDao.find(siteId);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


}
