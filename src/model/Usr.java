/*
 * Marco Cipriani (c) 2019.
 */

package model;

import java.util.Arrays;

public class Usr {

    private String username;
    private String name;
    private String pwd;
    private int roles; // 0 renter, 1 tenant, 2 renter + tenant
    private boolean reported; // 0 ok, 1 segnalato

    public Usr(String username, String name, String pwd, int roles, boolean reported) {
        this.username = username;
        this.name = name;
        this.pwd = pwd;
        this.roles = roles;
        this.reported = reported;
    }

    @Override
    public String toString() {
        String stringRoles; // per stampa comprensibile

        if (roles == 2) { stringRoles = "Tenant + Renter";
        } else if (roles == 1) { stringRoles = "Tenant";
        } else { stringRoles = "Renter"; }

        return "Utente: " + username +
                " (password '" + pwd + "\'" +
                ", segnalato " + reported + ")" +
                " di tipo " + stringRoles +
                ' ';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }
}
