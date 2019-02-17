/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class Apt {

    private int id;
    private String owner;
    private String address;

    public Apt(int id, String owner, String address) {
        this.id = id;
        this.owner = owner;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Appartamento numero " + id +
                ", in " + address +
                ", di prorietà di " + owner +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
