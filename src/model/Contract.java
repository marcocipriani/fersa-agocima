/*
  * Marco Cipriani (c) 2019.
 */

package model;

public class Contract {

    private int id;
    private String renter; // proprietario
    private String tenant; // affittuario
    private int apt; // appartamento in questione
    private boolean expired; // 0 in corso, 1 terminato

    public Contract(int id, String renter, String tenant, int apt, boolean expired) {
        this.id = id;
        this.renter = renter;
        this.tenant = tenant;
        this.apt = apt;
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Contratto numero " + id +
                ", Affittuario è stato " + renter +
                ", Proprietario è " + tenant +
                ", terminato? " + expired +
                '.';
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

    public String getTenant() { return tenant; }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public int getApt() { return apt; }

    public void setApt(int apt) { this.apt = apt; }

    public boolean isExpired() { return expired; }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
