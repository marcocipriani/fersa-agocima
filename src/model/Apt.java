/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class Apt {

    private int id;
    private String owner;
    private String address;

    public Apt(String owner, String address){
        this.id = 1;  // TO_DO incrementali
        this.owner = owner;
        this.address = address;
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
