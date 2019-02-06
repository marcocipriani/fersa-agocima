/*
 * Marco Cipriani (c) 2019.
 */

public class Eval {

    private int ID;
    private String text;
    private int stars;
    private String lastModified;
    private int status;

    public Eval(int id, String text, int stars, int status){
        this.ID = id;
        this.text = text;
        this.stars = stars;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
