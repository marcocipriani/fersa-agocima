/*
 * Marco Cipriani (c) 2019.
 */

package model;

public abstract class Eval {

    protected int id;
    protected String text; // corpo della valutazione
    protected int stars;
    protected boolean status; // 0 pending, 1 published
    protected String evalusr; // l'autore della valutazione
    protected int contractid;

    public Eval(int id, String text, int stars, boolean status, String evalusr, int contractid) {
        this.id = id;
        this.text = text;
        this.stars = stars;
        this.status = status;
        this.evalusr = evalusr;
        this.contractid = contractid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEvalusr() {
        return evalusr;
    }

    public void setEvalusr(String evalUsr) {
        this.evalusr = evalUsr;
    }

    public int getContractid() { return contractid; }

    public void setContractid(int contractid) { this.contractid = contractid; }
}
