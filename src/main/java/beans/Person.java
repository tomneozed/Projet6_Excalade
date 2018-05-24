package beans;

public class Person
{
    private int id;
    private String surname;
    private String fisrtName;

    public Person()
    {

    }

    public Person(int id, String surname, String firstName)
    {
        this.id = id;
        this.surname = surname;
        this.fisrtName = firstName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }
}
