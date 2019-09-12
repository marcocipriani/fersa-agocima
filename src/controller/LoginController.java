package controller;

import dao.UsrDAO;
import model.Usr;

public class LoginController {

    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null)
            instance = new LoginController();
        return instance;
    }

    private LoginController() {
    }

    /**
     * Carica l'utente corrispondente alla coppia username/password in input
     *
     * @param username username
     * @param password password
     * @return l'utente loggato oppure null se nessun utente corrisponde alla coppia username/password
     */
    public Usr login(String username, String password) {
        Usr u = UsrDAO.findByUsername(username, password, false);
        return u;
    }
}
