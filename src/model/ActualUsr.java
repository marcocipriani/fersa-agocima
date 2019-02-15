/*
 * Marco Cipriani (c) 2019.
 */

package model;


public class ActualUsr extends Usr{

    private boolean actualRole; // 0 renter, 1 tenant

/*    public ActualUsr(String nickname, String name, String[] roles, int[] aptlist, boolean actualRole) {
        super(nickname, name, roles, aptlist);
        this.actualRole = actualRole;
    }*/

    public ActualUsr(String nickname, String name, String[] roles, int[] aptlist) {
        super(nickname, name, roles, aptlist);
    }

    public boolean isActualRole() {
        return actualRole;
    }

    public void setActualRole(boolean actualRole) {
        this.actualRole = actualRole;
    }
}


