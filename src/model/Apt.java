/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class Apt {

    private int id;
    private String owner;
    private String address;
    private int number;

    public Apt(int id, String owner, String address, int number) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Appartamento #" + id +
                ", in " + address +
                ", " + number +
                ", di prorietà di " + owner +
                '.';
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

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }
}
