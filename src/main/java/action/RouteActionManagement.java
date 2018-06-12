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
        System.out.println("[doDetail] Area id : " + areaId);

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate()
    {
        //AreaId a une valeur puis devient null quand on appuie sur le bouton submit du formulaire
        System.out.println("[doCreate : 1] Area id : " + areaId);

        RouteDao routeDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        routeDao = daoFactory.getRouteDao();

        String vResult= ActionSupport.INPUT;

        // route!= null : check for errors
        if(this.route != null) {

            this.route.setAreaId(areaId);
            System.out.println(this.route.fullDescription());

            if(!this.hasErrors())
            {
                this.routeId = routeDao.add(this.route);

                this.route.setId(routeId);

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.route.added");
            }
        }

        // route = null : initialisation of form : add of area_id
        if(vResult.equals(ActionSupport.INPUT))
        {

        }

        return vResult;
    }

}
