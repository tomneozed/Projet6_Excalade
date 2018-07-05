package action;

import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.PersonDao;
import beans.Comment;
import beans.Person;
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
    private Person commentOwner;

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

    public Person getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(Person commentOwner) {
        this.commentOwner = commentOwner;
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
        PersonDao personDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        personDao = daoFactory.getPersonDao();

        if(commentId == null)
        {
            this.addActionError("error.comment.missing.id");
        }else
        {
            this.comment = commentDao.find(commentId);
            commentOwner = personDao.find(this.comment.getUser_id());
            System.out.println(this.comment.fullDescription());
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDelete()
    {
        CommentDao commentDao;
        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        String vResult;

        commentDao.delete(commentId);
        this.addActionMessage("success.comment.deleted");
        vResult= ActionSupport.SUCCESS;

        return vResult;
    }
}