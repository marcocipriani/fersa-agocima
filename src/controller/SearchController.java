package controller;

import java.util.Vector;

import dao.EvalAptDAO;
import dao.AptDAO;
import model.EvalApt;
import model.Apt;

import dao.EvalUsrDAO;
import dao.UsrDAO;
import model.EvalUsr;
import model.Usr;

public class SearchController {

	private SearchController() {
    }

	// for SearchAptView.jsp
	public static Vector<EvalApt> searchEvalAptList(int aptid){
		Vector<EvalApt> evalAptList = EvalAptDAO.searchById(aptid);
		System.out.println("@SearchController > searchEvalAptList: - " + evalAptList.size() + " valutazioni appartamento trovate");
		return evalAptList;
	}

	public static Vector<Apt> getAptList(String address){
		Vector<Apt> aptList = AptDAO.findByAddress(address);
		System.out.println("@SearchController > getAptList: - " + aptList.size() + " appartamenti trovati");
		return aptList;
	}


	// for SearchUsrView.jsp
	public static Vector<EvalUsr> searchEvalUsrList(String keyword){
		Vector<EvalUsr> evalUsrList = EvalUsrDAO.findEvalAboutYou(keyword);
		System.out.println("@SearchController > searchEvalUsrList: - " + evalUsrList.size() + " valutazioni utente trovate");
		return evalUsrList;
	}

	private static Usr findUser(String username){
		return (UsrDAO.findByUsername(username));
	}

	public static boolean isRealUsr(String username){
		return !(findUser(username) == null);
	}
}