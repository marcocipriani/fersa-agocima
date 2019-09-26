/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class EvalUsr extends Eval {

    private String username; // il destinatario della valutazione

    public EvalUsr(int id, String text, int stars, boolean status, String username, String evalusr, int contractid) {
        super(id, text, stars, status, evalusr, contractid);
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "Valutazione numero " + id +
                ", fatta da " + evalusr +
                " al termine del contratto " + contractid +
                ", di prorietà di " + username +
                ", che dice: " + text + 
                ", con voto: " + stars + '.';
        }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
