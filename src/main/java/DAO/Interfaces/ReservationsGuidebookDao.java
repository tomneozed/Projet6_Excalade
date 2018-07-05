package DAO.Interfaces;

import beans.ReservationsGuidebook;

import java.util.List;

public interface ReservationsGuidebookDao
{
    int add(ReservationsGuidebook reservation);

    void delete(int id);

    void update(int id, ReservationsGuidebook newReservation);

    List<ReservationsGuidebook> list();

    List<ReservationsGuidebook> listBySite(int siteId);

    List<ReservationsGuidebook> listByTenant(int tenantId);

    ReservationsGuidebook find(int id);
}
