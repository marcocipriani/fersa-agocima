package controller;

import dao.ContractDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;

import java.util.Vector;

public class ProfileController {

    public ProfileController() {
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
