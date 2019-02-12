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

    public EvalUsr(String text, int stars, String nickname, String evalusr) {
        this.id = 1; // TO_DO incrementali
        this.text = text;
        this.stars = stars;
        this.status = false; // impostata a 0 pending in fase di creazione
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
