/*
 * Marco Cipriani (c) 2019.
 */

import dao.EvalAptDAO;
import model.EvalApt;

public class Main {

    public static void main(String[] args) {

        EvalApt ea = EvalAptDAO.findByUsr("'Eros'");
        System.out.println(ea);
    }
}
