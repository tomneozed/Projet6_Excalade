package beans;

public class ReservationsGuidebook
{
    private int id;
    private int tenant_id;
    private int site_id;
    private String reservation_day_start;
    private String reservation_day_end;

    public ReservationsGuidebook() {
    }

    public ReservationsGuidebook(int id, int tenant_id, int site_id, String reservation_day_start, String reservation_day_end) {
        this.id = id;
        this.tenant_id = tenant_id;
        this.site_id = site_id;
        this.reservation_day_start = reservation_day_start;
        this.reservation_day_end = reservation_day_end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getReservation_day_start() {
        return reservation_day_start;
    }

    public void setReservation_day_start(String reservation_day_start) {
        this.reservation_day_start = reservation_day_start;
    }

    public String getReservation_day_end() {
        return reservation_day_end;
    }

    public void setReservation_day_end(String reservation_day_end) {
        this.reservation_day_end = reservation_day_end;
    }
}
