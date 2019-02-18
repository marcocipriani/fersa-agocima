package prove;

import dao.EvalAptDAO;
import model.EvalApt;
import dao.UsrDAO;
import model.Usr;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        EvalAptDAO.createEvalApt("Ciao", 4, 105, "Oriolo", "Marco");
        Vector<EvalApt> ea = EvalAptDAO.findYourApts("Marco");
        EvalAptDAO.deleteEvalApt(99);
        Usr us = UsrDAO.findByNickname("mcipriani", "fersa", false);
        
    }
}