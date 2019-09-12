/*
 * Marco Cipriani (c) 2019.
 */

package model;


public class ActualUsr extends Usr{

    private boolean actualRole = false; // 0 renter, 1 tenant

    public ActualUsr(String username, String name, String pwd, int roles, boolean reported, boolean actualRole) {
        super(username, name, pwd, roles, reported);
        this.actualRole = actualRole;
    }

    @Override
    public String toString() {
        String stringRole; // per stampa comprensibile

        if (actualRole) { stringRole = "Tenant";
        } else { stringRole = "Renter"; }

        return super.toString() + "attualmente loggato come " + stringRole;
    }

    public boolean isActualRole() {
        return actualRole;
    }

    public void setActualRole(boolean actualRole) {
        this.actualRole = actualRole;
    }
}


