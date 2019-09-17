package controller;

import dao.ContractDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;

public class CreateController {

    public static String[] getContractDetails(int contractId){
        return (ContractDAO.getDetails(contractId));
    }

    public static boolean postTenantForm(String text, int stars, String renter, String me){
        EvalUsrDAO.createEval(text, stars, renter, me);
        System.out.println("@CreateController.java - EvalUsr inviata");
        return true; //fake
    }

    public static boolean postRenterForm(String textUsr, int starsUsr, String textApt, int starsApt, int aptId, String tenant, String me){
        postTenantForm(textUsr, starsUsr, tenant, me);
        EvalAptDAO.createEval(textApt, starsApt, aptId, tenant, me);
        System.out.println("@CreateController.java - EvalApt inviata");

        return true; //fake
    }
}