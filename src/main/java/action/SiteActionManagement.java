package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.SiteDao;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class SiteActionManagement extends ActionSupport
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

    public String doCreate()
    {
        SiteDao siteDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();

        String vResult= ActionSupport.INPUT;


        // site!= null : check for errors
        if(this.site != null)
        {
            if(this.site.getState().length() < 2 && this.site.getState().length() > 40)
            {
                this.addFieldError("site.state", "error.site.state.size");
            }

            if(this.site.getRegion().length() < 2 && this.site.getRegion().length() > 40)
            {
                this.addFieldError("site.region", "error.site.region.size");
            }

            if(this.site.getCounty().length() < 2 && this.site.getCounty().length() > 40)
            {
                this.addFieldError("site.county", "error.site.county.size");
            }

            if(this.site.getName().length() < 2 && this.site.getName().length() > 40)
            {
                this.addFieldError("site.name", "error.site.name.size");
            }


            System.out.println(this.site.fullDescription());


            if(!this.hasErrors())
            {
                siteDao.add(this.site);

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.site.added");
            }
        }

        // route = null : initialisation of form : add of area_id

        if (vResult.equals(ActionSupport.INPUT))
        {

        }

        return vResult;
    }
}
