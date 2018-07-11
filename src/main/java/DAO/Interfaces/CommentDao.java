package DAO.Interfaces;

import beans.Comment;

import java.util.List;

public interface CommentDao {
    int add(Comment commentaire);

    void delete(int id);

    void update(int id, Comment newComment);

    List<Comment> list();

    List<Comment> listByArea(int areaId);

    Comment find(int id);
}