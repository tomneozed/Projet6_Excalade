package action;

import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.PersonDao;
import beans.Comment;
import beans.Person;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentActionManagement extends ActionSupport {
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer commentId;
    private Integer areaId;

    //- - - - Elements en sortie - - - -

    private List<Comment> commentList;
    private List<Person> commentOwnerList;
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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Person> getCommentOwnerList() {
        return commentOwnerList;
    }

    public void setCommentOwnerList(List<Person> commentOwnerList) {
        this.commentOwnerList = commentOwnerList;
    }

    //=========  METHODES  =========

    public String doList() {
        CommentDao commentDao;
        PersonDao personDao;
        commentOwnerList = new ArrayList<Person>();

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        personDao = daoFactory.getPersonDao();


        commentList = commentDao.listByArea(areaId);

        for (int i = 0; i < commentList.size(); i++) {
            commentList.get(i).setOwner(personDao.find(commentList.get(i).getUser_id()));
        }

        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        CommentDao commentDao;
        PersonDao personDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        personDao = daoFactory.getPersonDao();

        if (commentId == null) {
            addActionError("error.comment.missing.id");
        } else {
            comment = commentDao.find(commentId);
            commentOwner = personDao.find(comment.getUser_id());
            System.out.println(comment.fullDescription());
        }

        return (hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        CommentDao commentDao;
        Person user;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        Map session = ActionContext.getContext().getSession();

        String vResult = ActionSupport.INPUT;

        // route!= null : check for errors
        if (comment != null) {
            //Session user
            user = (Person) session.get("user");


            comment.setArea_id(areaId);
            comment.setUser_id(user.getId());

//            System.out.println("CommentActionManagment : doCreate : " + comment.fullDescription());

            if (!hasErrors()) {
                commentId = commentDao.add(comment);

                comment.setId(commentId);

                vResult = ActionSupport.SUCCESS;
                addActionMessage("success.comment.added");
            }
        }

        // comment = null :
        if (vResult.equals(ActionSupport.INPUT)) {

        }
        return vResult;
    }

    public String doDelete() {
        CommentDao commentDao;
        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();
        String vResult;

        if (commentId != null) {
            commentDao.delete(commentId);
            addActionMessage("success.comment.deleted");
            vResult = ActionSupport.SUCCESS;
        } else {
            addActionError("Erreur");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
}