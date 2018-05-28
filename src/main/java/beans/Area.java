package beans;

public class Area
{
    private int id;
    private int site_id;
    private String name;
    private String description;
    private String type;
    private int route_count;

    public Area()
    {

    }

    public Area(int id, String name, int route_count, String type, String description, int site_id)
    {
        this.id = id;
        this.site_id = site_id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.route_count = route_count;
    }


    public String fullDescription() {
        return "\n      ----- Secteur : "+ this.getName() + " -----"+
                " \nid : " + this.getId() +
                " \nNombre de voies: " + this.getRoute_count() +
                " \nType : " + this.getType() +
                " \nDescription : " + this.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoute_count() {
        return route_count;
    }

    public void setRoute_count(int route_count) {
        this.route_count = route_count;
    }
}
