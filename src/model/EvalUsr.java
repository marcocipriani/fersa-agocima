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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
