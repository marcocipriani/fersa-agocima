import dao.UsrDAO;

public class Controller {

    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    private Controller() {
    }

    /**
     * Carica l'utente corrispondente alla coppia username/password in input
     *
     * @param username nick
     * @param password pass
     * @return l'utente loggato oppure null se nessun utente corrisponde alla coppia username/password
     */
    public Utente login(String nick, String pass) {
    	checkboxValues = false;
        Utente u = UsrDAO.findByNickname(nick, pass, checkboxValues);
        return u;
    }
}