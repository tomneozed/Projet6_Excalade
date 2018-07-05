package action;

import DAO.DaoFactory;
import DAO.Interfaces.ReservationsGuidebookDao;
import beans.Person;
import beans.ReservationsGuidebook;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ReservationActionManagement extends ActionSupport implements SessionAware {

    //=========  ATTRIBUTS  =========
    //- - - - Elements en entrée - - - -
    private Integer siteId;
    private Integer reservationId;

    //- - - - Elements en sortie - - - -
    private ReservationsGuidebook reservation;
    private List<ReservationsGuidebook> reservationList;
    private Map<String, Object> session;

    //=========  GETTERS & SETTERS  =========

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationsGuidebook getReservation() {
        return reservation;
    }

    public void setReservation(ReservationsGuidebook reservation) {
        this.reservation = reservation;
    }

    public List<ReservationsGuidebook> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<ReservationsGuidebook> reservationList) {
        this.reservationList = reservationList;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> map) {

    }

    //=========  METHODES  =========

    public String doList() {
        ReservationsGuidebookDao reservationDao;
        Person user;

        DaoFactory daoFactory = DaoFactory.getInstance();
        reservationDao = daoFactory.getReservationDao();

        Map session = ActionContext.getContext().getSession();

        //Session user
        user = (Person)session.get("user");

        reservationList = reservationDao.listByTenant(user.getId());

        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        ReservationsGuidebookDao reservationDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        reservationDao = daoFactory.getReservationDao();

        if(reservationId == null)
        {
            this.addActionError("error.reservation.missing.id");
        }else
        {
            this.reservation = reservationDao.find(reservationId);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        Person user;
        ReservationsGuidebookDao reservationDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        reservationDao = daoFactory.getReservationDao();

        String vResult= ActionSupport.INPUT;

        // site!= null : check for errors
        if(this.reservation != null)
        {
            Map session = ActionContext.getContext().getSession();

            //Session user
            user = (Person)session.get("user");

            //Set tenant_id as user_id
            this.reservation.setTenant_id(user.getId());

            //Set site_id
            this.reservation.setSite_id(siteId);

            //LOG
            System.out.println(this.reservation.toString());

            if(!this.hasErrors())
            {
                this.reservationId = reservationDao.add(this.reservation);

                reservation.setId(reservationId);

                System.out.println(reservation.toString());

                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("success.reservation.added");
            }
        }

        if (vResult.equals(ActionSupport.INPUT))
        {

        }
        return vResult;
    }

    public String doDelete()
    {
        String vResult;
        ReservationsGuidebookDao reservationDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        reservationDao = daoFactory.getReservationDao();
        ResourceBundle bundle = ResourceBundle.getBundle("messages");

        if(session != null)
        {
            if(session.get("WW_TRANS_I18N_LOCALE") == "en")
            {
                bundle = ResourceBundle.getBundle("messages_en");
            }else
            {
                bundle = ResourceBundle.getBundle("messages");
            }
        }
        reservationDao.delete(reservationId);
        this.addActionMessage(bundle.getString("success.reservation.deleted"));
        vResult= ActionSupport.SUCCESS;

        return vResult;
    }
}
