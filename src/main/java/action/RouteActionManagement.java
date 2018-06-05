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

    //- - - - Elements en sortie - - - -

    private List<Route> routeList;
    private Route route;

    //=========  GETTERS & SETTERS  =========

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


    //=========  METHODES  =========

    public String doList()
    {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();
        this.routeList = routeDao.list();

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

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
