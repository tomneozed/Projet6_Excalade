package DAO.Interfaces;

import beans.Comment;

import java.util.List;

public interface CommentDao
{
    void add(Comment commentaire);

    void delete(int id);

    void update(int id, Comment newComment);

    List<Comment> list();

    Comment find(int id);
}