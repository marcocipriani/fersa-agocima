package controller;

import dao.ContractDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import dao.UsrDAO;

import model.ActualUsr;

import java.util.Vector;

public class ProfileController {

    public ProfileController() {
    }

    public static ActualUsr getUser(String username, String pwd, boolean loginRole ) {
    	ActualUsr au = UsrDAO.findByUsername(username, pwd, loginRole);
    	
    	if(loginRole && (au.getRoles() == 1 || au.getRoles() == 2)){
            au.setActualRole(true);
            System.out.println("@UsrDAO.java - Sei un proprietario tenant");
        } else if (!loginRole && (au.getRoles() == 0 || au.getRoles() == 2) ){
            System.out.println("@UsrDAO.java - Sei un inquilino renter");
        } else if (!loginRole && (au.getRoles() == 1)) {
            System.out.println("@UsrDAO.java - Hai provato come renter, Non hai i privilegi necessari");
        } else if (loginRole && (au.getRoles() == 0)) {
            System.out.println("@UsrDAO.java - Hai provato come tenant, Non hai i privilegi necessari");
        } else {
        	System.out.println("@UsrDAO.java - Altro caso");
        }
    	
    	return au;
    }
    
    private static Vector getList(String username, int type){
        Vector resulList = null;
        if (type == 0) {
            resulList = EvalUsrDAO.findEvalAboutYou(username);
        } else if (type == 1) {
            resulList = EvalUsrDAO.findEvalMadeByYou(username);
        } else if (type == 2){
            resulList = EvalAptDAO.findYourApts(username); // not available for renter
        } else if (type == 3) {
            resulList = ContractDAO.findAsRenter(username);
        } else if (type == 4) {
            resulList = ContractDAO.findAsTenant(username);
        }
        System.out.println("@ProfileController.java - " + resulList.size() + " risultati");
        return resulList;
    };

    public static Vector getEvalAboutYou(String username) {
        return (getList(username, 0));
    }

    public static Vector getEvalMadeByYou(String username) {
        return (getList(username, 1));
    }

    public static Vector getEvalAboutYourApts(String username){
        return (getList(username, 2));
    }

    public static Vector getContracts(String username, boolean isTenant){
        if (!isTenant) {
            return (getList(username, 3));
        }
        return (getList(username, 4));
    }
}
