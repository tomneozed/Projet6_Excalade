package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.PersonDao;
import DAO.Interfaces.SiteDao;
import beans.Area;
import beans.Person;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class AreaActionManagement extends ActionSupport {
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer areaId;
    private Integer siteId;
    private List<String> typeList = new ArrayList<String>();

    //- - - - Elements en sortie - - - -

    private List<Area> areaList;
    private Area area;
    private List<Person> commentOwnerList = new ArrayList<Person>();

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

    public List<Person> getCommentOwnerList() {
        return commentOwnerList;
    }

    public void setCommentOwnerList(List<Person> commentOwnerList) {
        this.commentOwnerList = commentOwnerList;
    }

    //=========  METHODES  =========

    public String doList() {
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();
        areaList = areaDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        AreaDao areaDao;
        PersonDao personDao;
        SiteDao siteDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();
        personDao = daoFactory.getPersonDao();
        siteDao = daoFactory.getSiteDao();

        if (areaId == null) {
            addActionError("error.area.missing.id");
        } else {
            area = areaDao.find(areaId);
            area.setOwnerId(siteDao.findOwnerId(area.getSiteId()));
            for (int i = 0; i < area.getCommentList().size(); i++) {
                commentOwnerList.add(personDao.find(area.getCommentList().get(i).getUser_id()));
            }
        }

        return (hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();

        String vResult = ActionSupport.INPUT;


        // route!= null : check for errors
        if (area != null) {
            if (area.getName().length() < 2 && area.getName().length() > 100) {
                addFieldError("area.name", "error.area.name.size");
            }

            if (area.getDescription().length() > 1000) {
                addFieldError("area.description", "error.area.description.size");
            }

            area.setSiteId(siteId);

            if (!hasErrors()) {

                areaId = areaDao.add(area);

                area.setId(areaId);

                System.out.println(area.fullDescription());

                vResult = ActionSupport.SUCCESS;
                addActionMessage("success.area.added");
            }
        }

        // route = null : initialisation of form : add of area_id

        if (vResult.equals(ActionSupport.INPUT)) {
            typeList.add("Falaise");
            typeList.add("Bloc");
        }
        return vResult;
    }

    public String doDelete() {
        AreaDao areaDao;
        String vResult;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();

        if (areaId != null) {
            areaDao.delete(areaId);
            addActionMessage("success.area.deleted");
            vResult = ActionSupport.SUCCESS;
        } else {
            addActionError("Error");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }


}
