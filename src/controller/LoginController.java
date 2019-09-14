package controller;

import model.Usr;
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

    public Usr login(String username, String password) {
        Usr u = UsrDAO.findByUsername(username, password, false);
        return u;
    }
}
