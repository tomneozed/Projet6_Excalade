package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.RouteDao;
import beans.Area;
import beans.Route;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class RouteActionManagement extends ActionSupport {
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

    public String doList() {
        RouteDao routeDao;
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();
        areaDao = daoFactory.getAreaDao();

        Area area = areaDao.find(areaId);
        routeList = routeDao.listByArea(areaId, area.getOwnerId());

        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        RouteDao routeDao;
        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        if (routeId == null) {
            addActionError("Vous devez indiquer un id de voie");
        } else {
            route = routeDao.find(routeId);
        }

        return (hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        String vResult = ActionSupport.INPUT;

        // route!= null : check for errors
        if (route != null) {

            route.setAreaId(areaId);
            System.out.println("doCreate : " + route.fullDescription());

            if (!hasErrors()) {
                routeId = routeDao.add(route);

                route.setId(routeId);

                vResult = ActionSupport.SUCCESS;
                addActionMessage("success.route.added");
            }
        }

        // route = null :
        if (vResult.equals(ActionSupport.INPUT)) {

        }
        return vResult;
    }

    public String doDelete() {
        RouteDao routeDao;
        DaoFactory daoFactory = DaoFactory.getInstance();

        routeDao = daoFactory.getRouteDao();
        String vResult;


        routeDao.delete(routeId);

        addActionMessage("success.site.deleted");
        vResult = ActionSupport.SUCCESS;

        return vResult;
    }

}
