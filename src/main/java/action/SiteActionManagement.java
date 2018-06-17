package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.SiteDao;
import beans.Person;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SiteActionManagement extends ActionSupport implements SessionAware
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer siteId;

    //- - - - Elements en sortie - - - -

    private List<Site> siteList;
    private Site site;
    private Map<String, Object> session;

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

    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
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
        Person user = new Person();
        SiteDao siteDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();

        String vResult= ActionSupport.INPUT;


        // site!= null : check for errors
        if(this.site != null)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();

            user = (Person)this.session.get("user");
            System.out.println("User id : " + user.getId());

            this.site.setOwnerId(user.getId());

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

            this.site.setAddDay(dateFormat.format(date));
            System.out.println(this.site.getAddDay()); //2016/11/16 12:08:43


            System.out.println(this.site.fullDescription());


            if(!this.hasErrors())
            {
                this.siteId = siteDao.add(this.site);

                site.setId(siteId);

                System.out.println(site.fullDescription());

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
