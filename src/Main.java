/*
 * Marco Cipriani (c) 2019.
 */

import dao.AptDAO;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import dao.UsrDAO;
import model.ActualUsr;
import model.Apt;
import model.Eval;
import model.EvalApt;
import model.EvalUsr;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        /*EvalAptDAO.createEval("Ciao", 4, 105, "Oriolo", "Marco");
        Vector<EvalApt> ea = EvalAptDAO.findEvalMadeByYou("Eros");
        System.out.println(ea);
        EvalAptDAO.deleteEval(8);*/

        // prova login
        ActualUsr au = UsrDAO.findByNickname("gcantone", "fersa", true);
        System.out.println(au);

        //prova appartamento
        Vector<Apt> addr = AptDAO.findApt("Via Nazionale 100");
        System.out.println(addr);
        Vector<Apt> own = AptDAO.findOwner("gcantone");
        System.out.println(own);
        
        Vector<EvalUsr> evusr = EvalUsrDAO.findYourEvals("Cesati");
        System.out.println(evusr.get(0));
    }
}
 

