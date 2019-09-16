package controller;

import model.ActualUsr;
import dao.UsrDAO;

public class LoginController {

    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null)
            instance = new LoginController();
        return instance;
    }

    private LoginController() {
    }

    public ActualUsr login(String username, String password, boolean loginRole) {
        ActualUsr au = UsrDAO.findByUsername(username, password, loginRole);
        
        if(loginRole && (au.getRoles() == 1 || au.getRoles()== 2)){
            au.setActualRole(true);
            System.out.println("@UsrDAO.java - Sei un proprietario tenant");
        } else if (!loginRole && (au.getRoles() == 0 || au.getRoles() ==2) ){
            System.out.println("@UsrDAO.java - Sei un inquilino renter");
        } else {
            System.out.println("@UsrDAO.java - Non hai i privilegi necessari");
        }

        return au;
    }
}
