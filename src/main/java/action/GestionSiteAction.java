package action;

import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.SiteDao;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GestionSiteAction extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer id;

    //- - - - Elements en sortie - - - -

    private List<Site> siteList;
    private Site site;

    //=========  GETTERS & SETTERS  =========

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        Site site;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();
        siteList = siteDao.list();

        if(id == null)
        {
            this.addActionError("Vous devez indiquer un id de commentaire");
        }else
        {
            this.site = siteList.get(id);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


}
