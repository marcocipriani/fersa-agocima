/*
 * Marco Cipriani (c) 2019.
 */

import dao.EvalAptDAO;
import model.EvalApt;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Vector<EvalApt> ea = EvalAptDAO.findByUsr("'Marco'");
        System.out.println(ea);
    }
}
