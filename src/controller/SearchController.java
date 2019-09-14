package controller;

import java.util.Vector;

import dao.EvalAptDAO;
import dao.EvalUsrDAO;

public class SearchController { 

	private SearchController() {
    }

	public static Vector searchList(boolean choice, String keyword) {
        if (!choice) {
        	Vector aptList = EvalAptDAO.findByAddress(keyword);
			System.out.println("@SearchController.java: " + aptList.size());
        	return aptList;
        } else {
			Vector usrList = EvalUsrDAO.findEvalAboutYou(keyword);
			System.out.println("@SearchController.java: " + usrList.size());
			return usrList;
        }
    }
}