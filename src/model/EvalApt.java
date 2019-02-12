/*
 * Marco Cipriani (c) 2019.
 */

package model;/*
 * Marco Cipriani (c) 2019.
 */

public class EvalApt {

    private int id;
    private String text; // corpo della valutazione
    private int stars;
    private boolean status; // 0 pending, 1 published
    private int aptid;
    private String owner; // il proprietario dell'appartamento
    private String evalusr; // l'autore della valutazione

    public EvalApt(String text, int stars, int aptid, String owner, String evalusr) {
        this.id = 1; // TO_DO incrementali
        this.text = text;
        this.stars = stars;
        this.status = false; // impostata a 0 pending in fase di creazione
        this.aptid = aptid;
        this.owner = owner;
        this.evalusr = evalusr;
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

    public int getAptid() {
        return aptid;
    }

    public void setAptid(int aptid) {
        this.aptid = aptid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEvalusr() {
        return evalusr;
    }

    public void setEvalusr(String evalusr) {
        this.evalusr = evalusr;
    }
}
