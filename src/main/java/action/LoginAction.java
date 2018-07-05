package action;

import DAO.DaoFactory;
import DAO.Interfaces.PersonDao;
import beans.Person;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Enumeration;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginAction extends ActionSupport implements SessionAware
{
    //=========  ATTRIBUTS  =========
    //- - - - Elements en entrée - - - -
    private String login;
    private String password;



    //=========  GETTERS & SETTERS  =========
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSession(Map<String, Object> map) {

    }

    //=========  METHODES  =========

    public String doLogin()
    {
        PersonDao personDao;

        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        DaoFactory daoFactory = DaoFactory.getInstance();
        personDao = daoFactory.getPersonDao();

        String vResult = ActionSupport.INPUT;

        if(!StringUtils.isAllEmpty(login, password))
        {
            try
            {
                Person vPerson = personDao.findByEmailNPassword(login, password);
                System.out.println(vPerson.fullDescription());

                if(vPerson.getId() == 0 || vPerson.getFirstName() == null || vPerson.getSurname() == null)
                {
                    this.addActionError(bundle.getString("error.login.failed"));
                    vResult = ActionSupport.ERROR;
                }else
                {
                    Map session = ActionContext.getContext().getSession();
                    //User is added in session
                    session.put("user", vPerson);

                    vResult = ActionSupport.SUCCESS;
                }

            }catch(NullPointerException pEx)
            {
                this.addActionError("error.login.failed");
            }
        }
        return vResult;
    }

    public String doLogout()
    {
        Map session = ActionContext.getContext().getSession();

        session.remove("user");

        return ActionSupport.SUCCESS;
    }


}
