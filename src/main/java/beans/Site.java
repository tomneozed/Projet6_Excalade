package beans;

public class Site
{
    private int id;
    private int owner_id;
    private String state;
    private String county;
    private String region;
    private String name;
    private String add_day;

    public Site()
    {

    }

    public Site(int id, int owner_id, String state, String county, String region, String name, String add_day) {
        this.id = id;
        this.owner_id = owner_id;
        this.state = state;
        this.county = county;
        this.region = region;
        this.name = name;
        this.add_day = add_day;
    }

    public String fullDescription() {
        return "\n\n******************** Site : "+ this.getName() + " ********************" +
                " \nid : " + this.getId() +
                " \nPropriétaire ID: " + this.getOwner_id() +
                " \nPays : " + this.getState() +
                " \nRegion : " + this.getRegion() +
                " \nDepartement : " + this.getCounty() +
                " \nDate d'ajout : " + this.getAdd_day();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd_day() {
        return add_day;
    }

    public void setAdd_day(String add_day) {
        this.add_day = add_day;
    }
}
