/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class EvalApt {

    private int id;
    private String text; // corpo della valutazione
    private int stars;
    private boolean status; // 0 pending, 1 published
    private int aptid;
    private String owner; // il proprietario dell'appartamento
    private String evalusr; // l'autore della valutazione

    public EvalApt(int id, String text, int stars, boolean status, int aptid, String owner, String evalusr) {
        this.id = id;
        this.text = text;
        this.stars = stars;
        this.status = status;
        this.aptid = aptid;
        this.owner = owner;
        this.evalusr = evalusr;
    }

    @Override
    public String toString() {
        return "Valutazione " +
                "numero " + id +
                " di " + evalusr +
                " sull'appartamento numero " + aptid +
                " di prorietà di " + owner +
                " valutato " + stars + " stelle " +
                text
                ;
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
