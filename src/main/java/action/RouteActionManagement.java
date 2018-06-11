package action;

import DAO.DaoFactory;
import DAO.Interfaces.RouteDao;
import beans.Route;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;

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

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
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

    public String doCreate()
    {
        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        String vResult= ActionSupport.INPUT;


        // route!= null : check for errors
        if(this.route != null)
        {
            if(this.route.getRoute_number() < 1)
            {
                this.addFieldError("route.number", "doit etre superieur a 0");
            }

            System.out.println(" --- DEBUG -- Numero de voie : " + this.getRoute().getRoute_number());

            if(this.route.getHeight() < 1)
            {
                this.addFieldError("route.number", "doit etre superieur a 1");
            }

            if(this.route.getHeight() < 1)
            {
                this.addFieldError("route.number", "doit etre superieur a 1");
            }

            this.route.setArea_id(1);

            System.out.println(this.route.fullDescription());


            if(!this.hasErrors())
            {
                routeDao.add(this.route);

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.route.added");
            }
        }

        // route = null : initialisation of form : add of area_id
        if(vResult.equals(ActionSupport.INPUT))
        {
            //this.route.setArea_id(1);
        }

        return vResult;
    }
}
