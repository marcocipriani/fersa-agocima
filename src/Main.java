/*
 * Marco Cipriani (c) 2019.
 */

import dao.EvalAptDAO;
import dao.UsrDAO;
import model.ActualUsr;
import model.EvalApt;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        EvalAptDAO.createEvalApt("Ciao", 4, 105, "Oriolo", "Marco");
        Vector<EvalApt> ea = EvalAptDAO.findByUsr("Marco");
        System.out.println(ea);
        EvalAptDAO.deleteEvalApt(99);

        // prova login
        ActualUsr au = UsrDAO.findByNickname("gcantone", "fersa", false);
    }
}
