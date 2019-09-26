/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class EvalApt extends Eval {

    private int aptid; // il codice dell'appartamento
    private String owner; // il proprietario dell'appartamento

    public EvalApt(int id, String text, int stars, boolean status, int aptid, String owner, String evalusr, int contractid) {
        super(id, text, stars, status, evalusr, contractid);
        this.aptid = aptid;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Valutazione " +
                "numero " + id +
                " di " + evalusr +
                " al termine del contratto " + contractid +
                " sull'appartamento numero " + aptid +
                " di prorietà di " + owner +
                " valutato " + stars + " stelle " +
                text
                ;
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
}
