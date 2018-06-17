package action;

import DAO.DaoFactory;
import DAO.Interfaces.PersonDao;
import beans.Person;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware
{
    //=========  ATTRIBUTS  =========
    //- - - - Elements en entrée - - - -
    private String login;
    private String password;

    private Map<String, Object> session;

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

    public void setSession(Map<String, Object> pSession)
    {
        this.session = pSession;
    }

    //=========  METHODES  =========

    public String doLogin()
    {
        PersonDao personDao;

        DaoFactory daoFactory = DaoFactory.getInstance();
        personDao = daoFactory.getPersonDao();

        String vResult = ActionSupport.INPUT;

        if(!StringUtils.isAllEmpty(login, password))
        {
            try
            {
                Person vPerson = personDao.findByEmailNPassword(login, password);

                //User is added in session
                this.session.put("user", vPerson);

                vResult = ActionSupport.SUCCESS;
            }catch(NullPointerException pEx)
            {
                this.addActionError("error.login.failed");
            }
        }
        return vResult;
    }

    public String doLogout()
    {
        this.session.remove("user");

        return ActionSupport.SUCCESS;
    }

}
