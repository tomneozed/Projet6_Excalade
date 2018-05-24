package beans;

public class Route
{
    private int id;
    private int area_id;
    private int route_number;
    private float height;
    private String grade;
    private int anchor_count;

    public Route() {
    }

    public Route(int id, int area_id, int route_number, float height, String grade, int anchor_count) {
        this.id = id;
        this.area_id = area_id;
        this.route_number = route_number;
        this.height = height;
        this.grade = grade;
        this.anchor_count = anchor_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getRoute_number() {
        return route_number;
    }

    public void setRoute_number(int route_number) {
        this.route_number = route_number;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAnchor_count() {
        return anchor_count;
    }

    public void setAnchor_count(int anchor_count) {
        this.anchor_count = anchor_count;
    }
}
