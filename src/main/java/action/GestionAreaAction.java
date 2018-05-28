package action;

import DAO.DaoFactory;
import DAO.Interfaces.AreaDao;
import DAO.Interfaces.CommentDao;
import beans.Area;
import beans.Comment;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GestionAreaAction extends ActionSupport
{
    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private Integer id;

    //- - - - Elements en sortie - - - -

    private List<Area> areaList;
    private Area area;
    private List<Comment> commentList;
    private Comment comment;

    //=========  GETTERS & SETTERS  =========

    public List<Area> getAreaList() {
        return areaList;
    }

    public Area getComment() {
        return area;
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
        AreaDao areaDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();
        areaList = areaDao.list();

        return ActionSupport.SUCCESS;
    }

    public String doDetail()
    {
        AreaDao areaDao;

        CommentDao commentDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        areaDao = daoFactory.getAreaDao();
        areaList = areaDao.list();

        commentDao = daoFactory.getCommentDao();
        commentList = commentDao.list();


        if(id == null)
        {
            this.addActionError("Vous devez indiquer un id de commentaire");
        }else
        {
            this.area = areaList.get(id);
            this.comment = commentList.get(id);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
