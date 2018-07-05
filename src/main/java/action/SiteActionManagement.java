package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.SiteDao;
import beans.Person;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import javax.swing.*;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();
        siteList = siteDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        SiteDao siteDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();

        if(siteId == null)
        {
            this.addActionError("error.site.missing.id");
        }else
        {
            this.site = siteDao.find(siteId);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate()
    {
        Person user ;
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

            formValidation(this.site);

            //Adding of current date
            this.site.setAddDay(dateFormat.format(date));

            //LOG
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

    public String doDelete()
    {
        SiteDao siteDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        siteDao = daoFactory.getSiteDao();

        String vResult;

        siteDao.delete(siteId);
        this.addActionMessage("success.site.deleted");
        vResult= ActionSupport.SUCCESS;

        return vResult;
    }

    private void formValidation(Site site)
    {
        ResourceBundle bundle;
        if(session.get("WW_TRANS_I18N_LOCALE") == "en")
        {
            bundle = ResourceBundle.getBundle("messages_en");
        }else
        {
            bundle = ResourceBundle.getBundle("messages");
        }

        if(site.getState().length() < 2 || site.getState().length() > 40)
        {
            this.addFieldError("site.state", bundle.getString("error.site.state.size"));
        }

        if(site.getRegion().length() < 2 || site.getRegion().length() > 40)
        {
            this.addFieldError("site.region", bundle.getString("error.site.region.size"));
        }

        if(site.getCounty().length() < 2 || site.getCounty().length() > 40)
        {
            this.addFieldError("site.county", bundle.getString("error.site.county.size"));
        }

        if(site.getName().length() < 2 || site.getName().length() > 40)
        {
            this.addFieldError("site.name", bundle.getString("error.site.name.size"));
        }
    }


}
