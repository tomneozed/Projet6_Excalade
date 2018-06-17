package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import beans.Area;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class AreaActionManagement extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer areaId;
    private Integer siteId;
    private List<String> typeList = new ArrayList<String>();

    //- - - - Elements en sortie - - - -

    private List<Area> areaList;
    private Area area;

    //=========  GETTERS & SETTERS  =========

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
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

    public String doCreate()
    {
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();

        String vResult= ActionSupport.INPUT;


        // route!= null : check for errors
        if(this.area != null)
        {
            if(this.area.getName().length() < 2 && this.area.getName().length() > 100)
            {
                this.addFieldError("area.name", "error.area.name.size");
            }

            if(this.area.getDescription().length() > 1000)
            {
                this.addFieldError("area.description", "error.area.description.size");
            }

            this.area.setSiteId(siteId);

            if(!this.hasErrors())
            {
                this.areaId = areaDao.add(this.area);

                area.setId(areaId);

                System.out.println(this.area.fullDescription());

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.area.added");
            }
        }

        // route = null : initialisation of form : add of area_id

        if (vResult.equals(ActionSupport.INPUT)) {
            this.typeList.add("Falaise");
            this.typeList.add("Bloc");
        }
        return vResult;
    }
}
