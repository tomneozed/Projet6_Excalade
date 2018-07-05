package DAO.Implementations;

import DAO.DaoFactory;
import DAO.Interfaces.PersonDao;
import beans.Person;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao
{
    private DaoFactory daoFactory;
    Connection connexion;

    public PersonDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public void add(Person person)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.person(surname, first_name, password, email)" +
                            "VALUES(?,?,?,?);");
            preparedStatement.setString(1, person.getSurname());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getPassword());
            preparedStatement.setString(4, person.getEmail());


            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "DELETE FROM public.person WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void update(int id, Person newPerson) {

        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "UPDATE public.person " +
                            "SET surname = ?, " +
                            "first_name = ? " +
                            "password = ? " +
                            "email = ? " +
                            "WHERE id = ?;");
            preparedStatement.setString(1, newPerson.getSurname());
            preparedStatement.setString(2, newPerson.getFirstName());
            preparedStatement.setString(3, newPerson.getPassword());
            preparedStatement.setString(4, newPerson.getEmail());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Person> list()
    {
        List<Person> personList = new ArrayList<Person>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM public.person;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                String surname = resultat.getString("surname");
                String firstName = resultat.getString("first_name");
                String password = resultat.getString("password");
                String email = resultat.getString("email");

                Person person = new Person(id, surname, firstName, password, email);

                personList.add(person);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return personList;
    }

    public Person find(int id) {
        Person person = new Person();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT * FROM public.person WHERE id="+ id +";");
            while (resultat.next())
            {
                String surname = resultat.getString("surname");
                String firstName = resultat.getString("first_name");
                String password = resultat.getString("password");
                String email = resultat.getString("email");

                person.setId(id);
                person.setSurname(surname);
                person.setFirstName(firstName);
                person.setPassword(password);
                person.setEmail(email);
            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return person;
    }

    public Person findByEmailNPassword(String email, String password)
    {
        Person person = new Person();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT * FROM public.person " +
                            "WHERE email='"+ email +"' AND password='" + password + "';");
            while (resultat.next())
            {
                int id = resultat.getInt("id");
                String surname = resultat.getString("surname");
                String firstName = resultat.getString("first_name");

                person.setId(id);
                person.setSurname(surname);
                person.setFirstName(firstName);
                person.setPassword(password);
                person.setEmail(email);

            }
            connexion.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return person;
    }
}
