package beans;

public class Route
{
    private int id;
    private int areaId;
    private int routeNumber;
    private float height;
    private String grade;
    private int anchorCount;
    private int ownerId;

    public Route() {
    }

    public Route(int id, int areaId, int routeNumber, float height, String grade, int anchorCount) {
        this.id = id;
        this.areaId = areaId;
        this.routeNumber = routeNumber;
        this.height = height;
        this.grade = grade;
        this.anchorCount = anchorCount;
    }

    public String fullDescription() {
        return "\n\n*** Route ***" +
                "\n id :" + id +
                "\n area_id :" + areaId +
                "\n numéro de voie :" + routeNumber +
                "\n hauteur : " + height +
                "\n cotation : " + grade +
                "\n nombre de splits : " + anchorCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
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

    public int getAnchorCount() {
        return anchorCount;
    }

    public void setAnchorCount(int anchorCount) {
        this.anchorCount = anchorCount;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
