package controller;

import dao.ContractDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import model.Contract;

import java.util.Vector;

public class CreateController {

    public static Vector getContractDetails(int contractId){
        return (ContractDAO.getDetails(contractId));
    }

    public static boolean postTenantForm(String text, int stars, String renter, String me, int contractid){
        EvalUsrDAO.createEval(text, stars, renter, me, contractid);
        System.out.println("@CreateController.java - EvalUsr inviata");
        return true; //fake
    }

    public static boolean postRenterForm(String textUsr, int starsUsr, String textApt, int starsApt, int aptId, String tenant, String me, int contractid){
        postTenantForm(textUsr, starsUsr, tenant, me, contractid);
        EvalAptDAO.createEval(textApt, starsApt, aptId, tenant, me, contractid);
        System.out.println("@CreateController.java - EvalApt inviata");

        return true; //fake
    }

}