package action;

import DAO.DaoFactory;
import DAO.Interfaces.SiteDao;
import beans.Site;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ResearchAction extends ActionSupport {

    //=========  ATTRIBUTS  =========

    //- - - - Elements en entrée - - - -

    private String researchInput;

    //- - - - Elements en sortie - - - -

    private List<Site> siteList;


    //=========  GETTERS & SETTERS  =========

    public String getResearchInput() {
        return researchInput;
    }

    public void setResearchInput(String researchInput) {
        this.researchInput = researchInput;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    //=========  METHODES  =========

    public String doList() {
        String as = ActionSupport.INPUT;
        try {
            if (researchInput.trim() == "") {
                addActionError("Veuillez écrire quelque chose !");
            } else {
                SiteDao siteDao;

                DaoFactory daoFactory = DaoFactory.getInstance();
                siteDao = daoFactory.getSiteDao();
                siteList = siteDao.researchList(researchInput);
                as = ActionSupport.SUCCESS;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return as;
    }


}
