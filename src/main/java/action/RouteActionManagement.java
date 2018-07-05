package action;

import DAO.DaoFactory;
import DAO.Interfaces.RouteDao;
import beans.Route;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class RouteActionManagement extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer routeId;
    private Integer areaId;
    private Integer siteId;

    //- - - - Elements en sortie - - - -

    private List<Route> routeList;
    private Route route;

    /* =========  GETTERS & SETTERS  ========= */

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    //=========  METHODES  =========

    public String doList()
    {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();
        this.routeList = routeDao.listByArea(areaId);

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        if(routeId == null)
        {
            this.addActionError("Vous devez indiquer un id de voie");
        }else
        {
            this.route = routeDao.find(routeId);
        }
        System.out.println("[doDetail] route.areaId : " + route.getAreaId());

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate()
    {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        String vResult= ActionSupport.INPUT;

        // route!= null : check for errors
        if(this.route != null) {

            this.route.setAreaId(areaId);
            System.out.println("doCreate : " + this.route.fullDescription());

            if(!this.hasErrors())
            {
                this.routeId = routeDao.add(this.route);

                this.route.setId(routeId);

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.route.added");
            }
        }

        // route = null :
        if(vResult.equals(ActionSupport.INPUT))
        {

        }

        return vResult;
    }

    public String doDelete()
    {
        RouteDao routeDao;
        DaoFactory daoFactory = DaoFactory.getInstance();

        routeDao = daoFactory.getRouteDao();
        String vResult;


        routeDao.delete(routeId);

        this.addActionMessage("success.site.deleted");
        vResult= ActionSupport.SUCCESS;

        return vResult;
    }

}
