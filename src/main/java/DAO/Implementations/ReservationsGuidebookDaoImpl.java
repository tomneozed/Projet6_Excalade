package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.ReservationsGuidebookDao;
import beans.ReservationsGuidebook;

import java.sql.*;
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

    public void add(ReservationsGuidebook reservation)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.reservations_guidebook(tenant_id, site_id, reservation_day_start, reservation_day_end)" +
                            "VALUES(?,?,?,?);");
            preparedStatement.setInt(1, reservation.getTenant_id());
            preparedStatement.setInt(2, reservation.getSite_id());
            preparedStatement.setString(3, reservation.getReservation_day_start());
            preparedStatement.setString(4, reservation.getReservation_day_end());

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

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
            resultat = statement.executeQuery("SELECT id, tenant_id, site_id, reservation_day_start, reservation_day_end FROM public.reservations_guidebook;");

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
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return reservationsList;
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
                    "SELECT tenant_id, site_id, reservation_day_start, reservation_day_end FROM public.reservations_guidebook WHERE id="+ id +";");
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

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return reservation;
    }
}
