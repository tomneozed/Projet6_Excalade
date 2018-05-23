package action;


import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import beans.Comment;
import com.opensymphony.xwork2.ActionSupport;
import DAO.Implementations.CommentDaoImpl;
import javassist.NotFoundException;

import java.util.List;

public class GestionCommentaireAction extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer id;

    //- - - - Elements en sortie - - - -

    private List<Comment> commentList;
    private Comment comment;

    //=========  GETTERS & SETTERS  =========

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Comment getComment() {
        return comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //=========  METHODES  =========

    public String doList()
    {
        CommentDao commentDao;
        Comment comment;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentaireDao();
        commentList = commentDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        CommentDao commentDao;
        Comment comment;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentaireDao();
        commentList = commentDao.list();

        if(id == null)
        {
            this.addActionError("Vous devez indiquer un id de commentaire");
        }else
        {
            this.comment = commentList.get(id);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
