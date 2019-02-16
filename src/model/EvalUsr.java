/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class EvalUsr {

    private int id;
    private String text; // corpo della valutazione
    private int stars;
    private boolean status; // 0 pending, 1 published
    private String nickname; // il destinatario della valutazione
    private String evalusr; // l'autore della valutazione

    public EvalUsr(int id, String text, int stars, boolean status, String nickname, String evalusr) {
        this.id = id;
        this.text = text;
        this.stars = stars;
        this.status = status;
        this.nickname = nickname;
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
}
