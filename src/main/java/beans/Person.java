package beans;

public class Person
{
    private int id;
    private String surname;
    private String fisrtName;
    private String password;
    private String email;

    public Person()
    {

    }

    public Person(int id, String surname, String fisrtName, String password, String email) {
        this.id = id;
        this.surname = surname;
        this.fisrtName = fisrtName;
        this.password = password;
        this.email = email;
    }

    public String fullDescription() {
        return "\n ----- Person -----" +
                "\n id = " + id +
                "\n surname = " + surname +
                "\n fisrtName = " + fisrtName +
                "\n password = " + password +
                "\n email = " + email ;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
