/*
 * Marco Cipriani (c) 2019.
 */

import model.EvalApt;

public class Main {

    private static EvalApt ea;

    public static void main(String[] args) {

        ea = EvalAptDAO.findByUsr("'Eros'");
        System.out.println(ea);
    }
}
