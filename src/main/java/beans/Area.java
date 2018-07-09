package beans;

import java.util.List;

public class Area {
    private int id;
    private int siteId;
    private String name;
    private String description;
    private String type;
    private int routeCount;
    private List<Route> routeList;
    private List<Comment> commentList;
    private int ownerId;

    public Area() {

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
        return "\n      ----- Secteur : " + getName() + " -----" +
            " \nid : " + getId() +
            " \nSiteId : " + getSiteId() +
            " \nNombre de voies: " + getRouteCount() +
            " \nType : " + getType() +
            " \nDescription : " + getDescription() +
            " \nListe des routes : " + routeDescription() +
            " \nListe des commentaires : " + commentDescription();
    }

    public String routeDescription() {
        String s = " ";
        if (routeList != null) {
            try {
                for (int i = 0; i < routeList.size(); i++) {
                    s += getRouteList().get(i).fullDescription();
                    s += "\n";
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            s = "Pas de routes associées";
        }

        return s;
    }

    public String commentDescription() {
        String s = " ";
        if (commentList != null) {
            try {
                for (int i = 0; i < commentList.size(); i++) {
                    s += getCommentList().get(i).fullDescription();
                    s += "\n";
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
