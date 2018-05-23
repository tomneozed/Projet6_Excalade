import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import beans.Comment;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        CommentDao commentDao;
        Comment comment;

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentaireDao();
        List<Comment> commentList = commentDao.list();

        for(int i = 0; i < commentList.size(); i++ )
        {
            comment = commentList.get(i);

            System.out.println("Commentaire : " + i);
        }

    }
}
