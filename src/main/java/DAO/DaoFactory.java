package DAO;

import DAO.Implementations.CommentDaoImpl;
import DAO.Implementations.PersonDaoImpl;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.PersonDao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DaoFactory
{
    private String url;
    private String username;
    private String password;

    public DaoFactory(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public static DaoFactory getInstance()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        DaoFactory instance = new DaoFactory("jdbc:postgresql://localhost:5432/excalade", "postgres", "azertyuiop");

        return instance;

    }

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username, password);
    }

    public CommentDao getCommentaireDao()
    {
        return new CommentDaoImpl(this);
    }

    public PersonDao getPersonDao()
    {
        return new PersonDaoImpl(this);
    }
}
