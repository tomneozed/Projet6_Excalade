package beans;

import java.util.List;

public class Area
{
    private int id;
    private int siteId;
    private String name;
    private String description;
    private String type;
    private int routeCount;
    private List<Route> routeList;
    private List<Comment> commentList;

    public Area()
    {

    }

    public Area(int id, int siteId, String name, String description, String type, int routeCount, List<Route> routeList, List<Comment> commentList) {
        this.id = id;
        this.siteId = siteId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.routeCount = routeCount;
        this.routeList = routeList;
        this.commentList = commentList;
    }

    public String fullDescription() {
        return "\n      ----- Secteur : "+ this.getName() + " -----"+
                " \nid : " + this.getId() +
                " \nNombre de voies: " + this.getRouteCount() +
                " \nType : " + this.getType() +
                " \nDescription : " + this.getDescription() +
                " \nListe des routes : " + this.routeDescription() +
                " \nListe des commentaires : " + this.commentDescription();
    }

    public String routeDescription()
    {
        String s =" ";
        if(this.routeList != null)
        {
            try
            {
                for(int i =0; i < this.routeList.size(); i++)
                {
                    s +=this.getRouteList().get(i).fullDescription();
                    s += "\n";
                }
            }catch(NullPointerException e)
            {
                e.printStackTrace();
            }
        }else
        {
            s = "Pas de routes associées";
        }

        return s;
    }

    public String commentDescription()
    {
        String s =" ";
        if(this.commentList != null)
        {
            try
            {
                for(int i =0; i < this.commentList.size(); i++)
                {
                    s +=this.getCommentList().get(i).fullDescription();
                    s += "\n";
                }
            }catch(NullPointerException e)
            {
                e.printStackTrace();
            }
        }else
        {
            s = "Pas de commentaire associées";
        }

        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
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

    public int getRouteCount() {
        return routeCount;
    }

    public void setRouteCount(int routeCount) {
        this.routeCount = routeCount;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
