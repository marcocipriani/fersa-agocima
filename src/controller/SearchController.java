package controller;

import java.util.Vector;

import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import dao.UsrDAO;
import model.Eval;
import model.EvalApt;
import model.EvalUsr;

public class SearchController { 

	private SearchController() {
    }
	
	public static Eval[] searchList(boolean choice, String keyword ) {
        if (choice == false) {
        	Vector evalList= EvalAptDAO.findEvalMadeByYou(keyword);
        	EvalApt[] e = new EvalApt[evalList.size()];
        	evalList.toArray(e);
        	return e;       	
        }
        else {
        	Vector evalList= EvalUsrDAO.findEvalMadeByYou(keyword);
        	EvalUsr[] e = new EvalUsr[evalList.size()];
        	evalList.toArray(e);
        	return e;       	
        }
    }

    

    /**
     * Carica l'utente corrispondente alla coppia username/password in input
     *
     * @param username username
     * @param password password
     * @return l'utente loggato oppure null se nessun utente corrisponde alla coppia username/password
     */
    
}


