/*
 * Marco Cipriani (c) 2019.
 */

import dao.AptDAO;
import dao.EvalAptDAO;
import dao.UsrDAO;
import model.ActualUsr;
import model.Apt;
import model.EvalApt;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        EvalAptDAO.createEvalApt("Ciao", 4, 105, "Oriolo", "Marco");
        Vector<EvalApt> ea = EvalAptDAO.findEvalMadeByYou("Marco");
        System.out.println(ea);
        EvalAptDAO.deleteEvalApt(99);

        // prova login
        ActualUsr au = UsrDAO.findByNickname("gcantone", "fersa", true);
        System.out.println(au);

        // prova appartamento
        Vector<Apt> addr = AptDAO.findApt("Via" + " " + "Cambridge" + " " + "20");
        System.out.println(addr);
        Vector<Apt> own = AptDAO.findOwner("gcantone");
        System.out.println(own);
    }
}
