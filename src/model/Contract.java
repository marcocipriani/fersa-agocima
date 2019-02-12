/*
 * Marco Cipriani (c) 2019.
 */

package model;

public class Contract {

    private int id;
    private String renter; // proprietario
    private String tenant; // affittuario

    public Contract(String renter, String tenant){
        this.id = 1;
        this.renter = renter;
        this.tenant = tenant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
