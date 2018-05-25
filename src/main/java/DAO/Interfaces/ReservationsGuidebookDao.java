package DAO.Interfaces;

import beans.ReservationsGuidebook;

import java.util.List;

public interface ReservationsGuidebookDao
{
    void add(ReservationsGuidebook reservation);

    void delete(int id);

    void update(int id, ReservationsGuidebook newReservation);

    List<ReservationsGuidebook> list();

    ReservationsGuidebook find(int id);
}
