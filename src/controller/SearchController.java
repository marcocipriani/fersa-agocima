package controller;

import java.util.Vector;

import dao.AptDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import dao.UsrDAO;
import model.Apt;
import model.EvalApt;
import model.Usr;

public class SearchController {

	private SearchController() {
    }

	public static Vector searchEvalList(boolean choice, String keyword) {
        if (!choice) {
        	Vector evalAptList = EvalAptDAO.findByAddress(keyword);
			System.out.println("@SearchController.java: - " + evalAptList.size() + " risultati");
        	return evalAptList;
        } else {
			Vector evalUsrList = EvalUsrDAO.findEvalAboutYou(keyword);
			System.out.println("@SearchController.java: - " + evalUsrList.size() + " risultati");
			return evalUsrList;
        }
    }

    public static Vector<EvalApt> searchEvalAptList(int aptid){
		Vector<EvalApt> evalAptList = EvalAptDAO.searchById(aptid);
		System.out.println("@SearchController.java: - " + evalAptList.size() + " risultati");
		return evalAptList;
	}

    public static Apt getApt(int aptid){
		return (AptDAO.findByID(aptid));
	}

	public static Vector<Apt> getAptList(String address){
		Vector<Apt> aptList = AptDAO.findByAddress(address);
		System.out.println("@SearchController.java: - " + aptList.size() + " risultati");
		return aptList;
	}

	private static Usr findUser(String username){
		return (UsrDAO.searchByUsername(username));
	}

	public static String getNameUsr(String username){
		Usr u = findUser(username);
		return (u.getName());
	}

	public static boolean isRealUsr(String username){
		return !(findUser(username) == null);
	}

    public static double getAvg(int aptid){
		return (EvalAptDAO.getAvg(aptid));
	}
}