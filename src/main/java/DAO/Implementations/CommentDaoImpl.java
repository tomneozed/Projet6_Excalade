package DAO.Implementations;

import DAO.Interfaces.CommentDao;
import beans.Comment;
import DAO.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao
{
    private DaoFactory daoFactory;
    private Connection connexion;

    public CommentDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public void add(Comment comment)
    {
        PreparedStatement preparedStatement;
        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO public.comment(text, user_id, area_id) " +
                            "VALUES(?,?,?);");
            preparedStatement.setString(1, comment.getText());
            preparedStatement.setInt(2, comment.getUser_id());
            preparedStatement.setInt(3, comment.getArea_id());

            preparedStatement.executeUpdate();
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
                    "DELETE FROM public.comment WHERE id = ?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(int id, Comment newComment)
    {
        PreparedStatement preparedStatement;

        try
        {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "UPDATE public.comment " +
                            "SET text = ?, " +
                            "user_id = ?, " +
                            "area_id = ?" +
                            "WHERE id = ?;");
            preparedStatement.setString(1, newComment.getText());
            preparedStatement.setInt(2, newComment.getUser_id());
            preparedStatement.setInt(3, newComment.getArea_id());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Comment> list()
    {
        List<Comment> comments = new ArrayList<Comment>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, text, user_id, area_id FROM public.comment;");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                String text = resultat.getString("text");
                int user_id = resultat.getInt("user_id");
                int area_id = resultat.getInt("area_id");

                Comment comment = new Comment(id, text, user_id, area_id);

                comments.add(comment);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Comment> listByArea(int areaId)
    {
        List<Comment> commentListByArea = new ArrayList<Comment>();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM comment WHERE area_id = " + areaId + ";");

            while(resultat.next())
            {
                int id = resultat.getInt("id");
                String text = resultat.getString("text");
                int user_id = resultat.getInt("user_id");
                int area_id = resultat.getInt("area_id");

                Comment comment = new Comment(id, text, user_id, area_id);

                commentListByArea.add(comment);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return commentListByArea;
    }

    public Comment find(int id)
    {
        Comment comment = new Comment();
        Statement statement;
        ResultSet resultat;

        try
        {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(
                    "SELECT text, user_id, area_id FROM public.comment WHERE id="+ id +";");
            while (resultat.next())
            {
                String text = resultat.getString("text");
                int user_id = resultat.getInt("user_id");
                int area_id = resultat.getInt("area_id");

                comment.setId(id);
                comment.setText(text);
                comment.setUser_id(user_id);
                comment.setArea_id(area_id);
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return comment;
    }
}
