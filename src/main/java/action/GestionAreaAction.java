package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.CommentDao;
import beans.Area;
import beans.Comment;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GestionAreaAction extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer areaId;
    private Integer siteId;

    //- - - - Elements en sortie - - - -

    private List<Area> areaList;
    private Area area;

    //=========  GETTERS & SETTERS  =========

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    //=========  METHODES  =========

    public String doList()
    {
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();
        this.areaList = areaDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();

        if(areaId == null)
        {
            this.addActionError("Vous devez indiquer un id de secteur");
        }else
        {
            this.area = areaDao.find(areaId);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
