import DAO.DaoFactory;
import DAO.Interfaces.*;
import beans.*;

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

        /*
        CommentDao commentDao;
        Comment comment;


        Comment c2 = new Comment();
        c2.setArea_id(1);
        c2.setUser_id(1);
        c2.setText("Teste 2");

        DaoFactory daoFactory = DaoFactory.getInstance();
        commentDao = daoFactory.getCommentDao();

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

        */

        SiteDao siteDao;
        Site site;

        AreaDao areaDao;
        Area area;

        CommentDao commentDao;
        Comment comment;

        PersonDao personDao;
        Person person;

        RouteDao routeDao;
        Route route;

        DaoFactory daoFactory3 = DaoFactory.getInstance();
        siteDao = daoFactory3.getSiteDao();

        DaoFactory daoFactory4 = DaoFactory.getInstance();
        areaDao = daoFactory4.getAreaDao();

        DaoFactory daoFactory5 = DaoFactory.getInstance();
        commentDao = daoFactory5.getCommentDao();

        DaoFactory daoFactory6 = DaoFactory.getInstance();
        personDao = daoFactory6.getPersonDao();

        DaoFactory daoFactory7 = DaoFactory.getInstance();
        routeDao = daoFactory7.getRouteDao();

        List<Site> siteList = siteDao.list();

        List<Area> areaList = areaDao.list();

        List<Comment> commentList = commentDao.list();

        List<Person> personList = personDao.list();

        List<Route> routeList = routeDao.list();


        site = siteList.get(3);

        System.out.println(site.fullDescription());

//        for(int i = 0; i < siteList.size(); i++ )
//        {
//            site = siteList.get(i);
//
//            System.out.println(site.fullDescription());
//
//            for (int j = 0; j < areaList.size(); j++)
//            {
//                area = areaList.get(j);
//
//                if(area.getSite_id() == site.getId())
//                {
//                    System.out.println(area.fullDescription());
//                }
//
//                for (int k = 0; k < routeList.size(); k++)
//                {
//                    route = routeList.get(k);
//
//                    if (route.getArea_id() == area.getId())
//                    {
//                        System.out.println(route.fullDescription());
//                    }
//                }
//
//                System.out.println("\n----- Commentaires -----");
//
//                for(int k = 0; k < commentList.size(); k++)
//                {
//                    comment = commentList.get(k);
//
//                    if(comment.getArea_id() == area.getId())
//                    {
//                        for(int l =0; l < personList.size(); l++)
//                        {
//                            person = personList.get(l);
//
//                            if(comment.getUser_id() == person.getId())
//                            {
//                                System.out.println(person.getFisrtName() + " " + person.getSurname());
//                                System.out.println(comment.getText());
//                            }
//
//                        }
//                    }
//                }
//            }
//        }



//        System.out.println("*******************TEST AREA LIST BY SITE*******************");
//
//        List<Area> areaListBySite = areaDao.listBySite(3);
//
//        for(int i = 0; i < areaListBySite.size(); i++)
//        {
//            System.out.println(areaListBySite.get(i).fullDescription());
//        }

//        System.out.println("CommentList.size() : " + commentList.size());
//
//        for(int k = 0; k < commentList.size(); k++)
//        {
//            comment = commentList.get(k);
//
//            System.out.println("\n    Commentaires : "+
//                    //personList.get(comment.getUser_id()).getSurname() + " " + personList.get(comment.getUser_id()).getFisrtName() + "\n" +
//                    comment.getText());
//
//        }


    }

    public static int countArea(int site_id, List<Area> areaList)
    {
        int number = 0;

        for(int i = 0; i < areaList.size(); i++)
        {
            if(areaList.get(i).getSite_id() == site_id)
            {
                number++;
            }
        }
        return number;
    }
}
