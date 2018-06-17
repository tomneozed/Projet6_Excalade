package beans;

public class Comment
{
    private String text;
    private int id;
    private int user_id;
    private int area_id;

    public Comment()
    {

    }

    public Comment(int id, String text, int user_id, int secteur_id)
    {
        this.id = id;
        this.text = text;
        this.user_id = user_id;
        this.area_id = secteur_id;
    }

    public String fullDescription() {
        return "\n      ----- Secteur : "+ this.getId() + " -----"+
                " \nText : " + this.getText() +
                " \nUser ID : " + this.getUser_id() +
                " \nArea ID : " + this.getArea_id();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }
}
