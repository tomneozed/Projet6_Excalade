package beans;

import java.util.List;

public class Site
{
    private int id;
    private int ownerId;
    private String state;
    private String county;
    private String region;
    private String name;
    private String addDay;
    private List<Area> areaList;

    public Site()
    {

    }

    public Site(int id, int ownerId, String state, String county, String region, String name, String addDay, List<Area> areaList) {
        this.id = id;
        this.ownerId = ownerId;
        this.state = state;
        this.county = county;
        this.region = region;
        this.name = name;
        this.addDay = addDay;
        this.areaList = areaList;
    }

    public String fullDescription() {
        return "\n\n******************** Site : "+ this.getName() + " ********************" +
                " \nid : " + this.getId() +
                " \nPropriétaire ID: " + this.getOwnerId() +
                " \nPays : " + this.getState() +
                " \nRegion : " + this.getRegion() +
                " \nDepartement : " + this.getCounty() +
                " \nDate d'ajout : " + this.getAddDay() +
                " \nListe des secteurs : \n" + this.areaDescription();
    }

    public String areaDescription()
    {
        String s =" ";
        if(areaList != null)
        {
            try
            {
                for(int i =0; i < this.areaList.size(); i++)
                {
                    s +=this.getAreaList().get(i).fullDescription();
                    s += "\n";
                }

            }catch(NullPointerException e)
            {
                e.printStackTrace();
            }
        }

        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public String getAddDay() {
        return addDay;
    }

    public void setAddDay(String addDay) {
        this.addDay = addDay;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
