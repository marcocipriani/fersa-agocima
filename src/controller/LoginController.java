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
        ActualUsr au = UsrDAO.findByUsernameAndPassword(username, password, loginRole);
        
        

        return au;
    }
}
