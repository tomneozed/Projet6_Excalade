import DAO.DaoFactory;
import DAO.Interfaces.CommentDao;
import DAO.Interfaces.PersonDao;
import beans.Comment;
import beans.Person;

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


        Comment c2 = new Comment();
        c2.setArea_id(1);
        c2.setUser_id(1);
        c2.setText("Teste 2");

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentaireDao();

        //test add
        commentDao.add(c2);

        //test delete
        commentDao.delete(21);

        //test list
        List<Comment> commentList = commentDao.list();

        for(int i = 0; i < commentList.size(); i++ )
        {
            comment = commentList.get(i);

            System.out.println("Commentaire : " + comment.getId() + " " + comment.getText());
        }

        //test find
        Comment newComment = commentDao.find(23);
        System.out.println("Find : " + newComment.getId() + " : " +newComment.getText());

        //test update
        commentDao.update(6, c2);

        PersonDao personDao;
        Person p;

        DaoFactory daoFactory2 = DaoFactory.getInstance();
        personDao = daoFactory2.getPersonDao();

        List<Person> personList = personDao.list();

        for(int i = 0; i < personList.size(); i++ )
        {
            p = personList.get(i);

            System.out.println("Personne : " + p.getId() + " " + p.getFisrtName() + " " + p.getSurname());
        }

    }
}
