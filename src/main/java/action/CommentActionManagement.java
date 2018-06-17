package action;

import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import beans.Comment;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class CommentActionManagement extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer commentId;

    //- - - - Elements en sortie - - - -

    private List<Comment> commentList;
    private Comment comment;

    //=========  GETTERS & SETTERS  =========


    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }


    //=========  METHODES  =========

    public String doList()
    {
        CommentDao commentDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        commentList = commentDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        CommentDao commentDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();

        if(commentId == null)
        {
            this.addActionError("error.comment.missing.id");
        }else
        {
            this.comment = commentDao.find(commentId);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}