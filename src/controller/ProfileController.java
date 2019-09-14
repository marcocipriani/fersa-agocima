package controller;

import dao.EvalAptDAO;
import dao.EvalUsrDAO;

import java.util.Vector;

public class ProfileController {

    public ProfileController() {
    }

    public static Vector getList(String username){
        Vector evalList = EvalUsrDAO.findEvalAboutYou(username);
        System.out.println("@ProfileController.java - " + evalList.size() + " risultati");
        return evalList;
    };
}
