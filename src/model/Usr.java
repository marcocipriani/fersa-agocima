/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class Usr {

    private String nickname;
    private String name;
    private String pwd;
    private String[] roles;
    private int[] aptlist;
    private boolean reported; // 0 ok, 1 segnalato

    public Usr(String nickname, String name, String[] roles, int[] aptlist) {
        this.nickname = nickname;
        this.name = name;
        this.roles = roles;
        this.aptlist = aptlist;
    }

    public Usr(String nickname, String name, String pwd, String[] roles, int[] aptlist, boolean reported) {
        this.nickname = nickname;
        this.name = name;
        this.pwd = pwd;
        this.roles = roles;
        this.aptlist = aptlist;
        this.reported = reported;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public int[] getAptlist() {
        return aptlist;
    }

    public void setAptlist(int[] aptlist) {
        this.aptlist = aptlist;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }
}
