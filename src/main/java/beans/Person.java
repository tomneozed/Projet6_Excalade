package beans;

public class Person
{
    private int id;
    private String surname;
    private String firstName;
    private String password;
    private String email;

    public Person()
    {

    }

    public Person(int id, String surname, String firstName, String password, String email) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public String fullDescription() {
        return "\n ----- Person -----" +
                "\n id = " + id +
                "\n surname = " + surname +
                "\n firstName = " + firstName +
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
