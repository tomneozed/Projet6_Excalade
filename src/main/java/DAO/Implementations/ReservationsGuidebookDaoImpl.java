package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.ReservationsGuidebookDao;
import beans.ReservationsGuidebook;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservationsGuidebookDaoImpl implements ReservationsGuidebookDao
{
    private DaoFactory daoFactory;
    Connection connexion;

    public ReservationsGuidebookDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public int add(ReservationsGuidebook reservation)
    {
        PreparedStatement preparedStatement;
        int reservationId = -1;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            //Date translation : String --> Date
            //Date dateStart = (Date) formatter.parse(reservation.getReservation_day_start());
//            Date dateEnd = (Date) formatter.parse(reservation.getReservation_day_end());
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//            java.util.Date date = sdf1.parse(reservation.getReservation_day_start());
//            java.sql.Date dateStart = new java.sql.Date(date.);
            String dateDebut="";
            String dateFin="";

            for(int i=0; i <10 ; i++)
            {
                dateDebut += reservation.getReservation_day_start().charAt(i);
                dateFin += reservation.getReservation_day_end().charAt(i);
            }

            System.out.println("date debut : " + dateDebut);
            System.out.println("date fin : " + dateFin);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(dateDebut);
            java.sql.Date dateStart = new java.sql.Date(parsed.getTime());

            java.util.Date parsedFin = format.parse(dateFin);
            java.sql.Date dateEnd = new java.sql.Date(parsedFin.getTime());

            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.reservations_guidebook(tenant_id, site_id, reservation_day_start, reservation_day_end)" +
                            "VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reservation.getTenant_id());
            preparedStatement.setInt(2, reservation.getSite_id());
            preparedStatement.setDate(3, dateStart);
            preparedStatement.setDate(4, dateEnd);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next())
            {
                reservationId = rs.getInt(1);
            }

            System.out.println("[add] reservationId : " + reservationId);
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reservationId;
    }

    public void delete(int id)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "DELETE FROM public.reservations_guidebook WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void update(int id, ReservationsGuidebook newReservation) {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "UPDATE public.reservations_guidebook " +
                            "SET tenant_id = ?, " +
                            "site_id = ?, " +
                            "reservation_day_start = ?, " +
                            "reservation_day_end = ? " +
                            "WHERE id = ?;");
            preparedStatement.setInt(1, newReservation.getTenant_id());
            preparedStatement.setInt(2, newReservation.getSite_id());
            preparedStatement.setString(3, newReservation.getReservation_day_start());
            preparedStatement.setString(4, newReservation.getReservation_day_end());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<ReservationsGuidebook> list()
    {
        List<ReservationsGuidebook> reservationsList = new ArrayList<ReservationsGuidebook>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.reservations_guidebook;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int tenant_id = resultat.getInt("tenant_id");
                int site_id = resultat.getInt("site_id");
                String reservation_day_start = resultat.getString("reservation_day_start");
                String reservation_day_end = resultat.getString("reservation_day_end");


                ReservationsGuidebook reservation = new ReservationsGuidebook(id, tenant_id, site_id, reservation_day_start, reservation_day_end);

                reservationsList.add(reservation);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return reservationsList;
    }

    public List<ReservationsGuidebook> listBySite(int siteId) {

        List<ReservationsGuidebook> reservationListBySite = new ArrayList<ReservationsGuidebook>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.reservations_guidebook " +
                    "WHERE site_id =" + siteId + ";");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int tenant_id = resultat.getInt("tenant_id");
                int site_id = resultat.getInt("site_id");
                String reservation_day_start = resultat.getString("reservation_day_start");
                String reservation_day_end = resultat.getString("reservation_day_end");

                ReservationsGuidebook reservation = new ReservationsGuidebook(id, tenant_id, site_id, reservation_day_start, reservation_day_end);

                reservationListBySite.add(reservation);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return reservationListBySite;
    }

    public List<ReservationsGuidebook> listByTenant(int tenantId) {

        List<ReservationsGuidebook> reservationListByTenant = new ArrayList<ReservationsGuidebook>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.reservations_guidebook " +
                    "WHERE tenant_id =" + tenantId + ";");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                int tenant_id = resultat.getInt("tenant_id");
                int site_id = resultat.getInt("site_id");
                String reservation_day_start = resultat.getString("reservation_day_start");
                String reservation_day_end = resultat.getString("reservation_day_end");

                ReservationsGuidebook reservation = new ReservationsGuidebook(id, tenant_id, site_id, reservation_day_start, reservation_day_end);

                reservationListByTenant.add(reservation);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return reservationListByTenant;
    }

    public ReservationsGuidebook find(int id)
    {
       ReservationsGuidebook reservation = new ReservationsGuidebook();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT * FROM public.reservations_guidebook WHERE id="+ id +";");
            while (resultat.next())
            {
                int tenant_id = resultat.getInt("tenant_id");
                int site_id = resultat.getInt("site_id");
                String reservation_day_start = resultat.getString("reservation_day_start");
                String reservation_day_end = resultat.getString("reservation_day_end");

                reservation.setId(id);
                reservation.setTenant_id(tenant_id);
                reservation.setSite_id(site_id);
                reservation.setReservation_day_start(reservation_day_start);
                reservation.setReservation_day_end(reservation_day_end);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return reservation;
    }
}
