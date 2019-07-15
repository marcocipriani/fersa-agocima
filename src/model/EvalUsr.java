/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class EvalUsr extends Eval {

    private String nickname; // il destinatario della valutazione

    public EvalUsr(int id, String text, int stars, boolean status, String nickname, String evalusr) {
        super(id, text, stars, status, evalusr);
        this.nickname = nickname;
    }
    
    @Override
    public String toString() {
        return "Valutazione numero " + id +
                ", fatta da " + evalusr +
                ", di prorietà di " + nickname +
                ", che dice: " + text + 
                ", con voto: " + stars + '.';
        }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getEvalusr() {
        return evalusr;
    }

    public void setEvalusr(String evalusr) {
        this.evalusr = evalusr;
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
    
    
}
