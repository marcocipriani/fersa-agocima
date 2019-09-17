package controller;

import dao.ContractDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import dao.UsrDAO;

import model.ActualUsr;
import model.Contract;
import model.Eval;

import java.util.HashSet;
import java.util.Set;
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
        Vector resultList = null;
        if (type == 0) {
            resultList = EvalUsrDAO.findEvalAboutYou(username);
        } else if (type == 1) {
            resultList = EvalUsrDAO.findEvalMadeByYou(username);
        } else if (type == 2){
            resultList = EvalAptDAO.findYourApts(username); // not available for renter
        } else if (type == 3) {
            resultList = ContractDAO.findAsRenter(username);
        } else if (type == 4) {
            resultList = ContractDAO.findAsTenant(username);
        } else  if (type == 5){
            resultList = EvalAptDAO.findEvalMadeByYou(username);
        }
        System.out.println("@ProfileController.java - " + resultList.size() + " risultati");
        return resultList;
    };

    public static Vector getEvalAboutYou(String username) { return (getList(username, 0));
    }

    public static Vector getEvalMadeByYou(String username) {
        Vector result = new Vector();
        Vector a = getList(username, 1);
        Vector b = getList(username, 5);
        result.addAll(a);
        result.addAll(b);

        return result;
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
    
    public static boolean selectId(Contract c, Vector<Eval> v) {
    	Set<Integer> uniqueId = new HashSet<Integer>();
    	for (int i=0; i<v.size();i++) {
    		uniqueId.add(v.elementAt(i).getContractid());
    		}
    	if(uniqueId.contains(c.getId())) {
    		return true;
    	}else {
		return false;	
    	}
    }
    	
}
