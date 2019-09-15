/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.Contract;

import java.sql.*;
import java.util.Vector;

public class ContractDAO {

    private static final String SEARCH_RENTER_QUERY = "select * from contract where renter = ?";
    private static final String SEARCH_TENANT_QUERY = "select * from contract where tenant = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    public static Vector<Contract> findAsRenter(String username) {

        Vector<Contract> results = new Vector<Contract>();
        Contract c;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_RENTER_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                                        // unnecessary if rs is not scrolled
            stmt.setString(1, username);
            System.out.println("@ContractDao - Final statement: " + stmt);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.first(); // is it worth it?

            while (rs.next()) {
                    c = new Contract(
                            rs.getInt("id"),
                            rs.getString("renter"),
                            rs.getString("tenant"),
                            rs.getInt("apt"),
                            rs.getBoolean("expired")
                    );
                    results.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static Vector<Contract> findAsTenant(String username) {

        Vector<Contract> results = new Vector<Contract>();
        Contract c;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_TENANT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                                        // unnecessary if rs is not scrolled

            stmt.setString(1, username);
            System.out.println("@ContractDao - Final statement: " + stmt);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.first(); // is it worth it?

            while (rs.next()) {
                c = new Contract(
                        rs.getInt("id"),
                        rs.getString("renter"),
                        rs.getString("tenant"),
                        rs.getInt("apt"),
                        rs.getBoolean("expired")
                );
                results.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    /*public static Vector<Contract> findReadyToEvaluate(String username, boolean isTenant) {
        // if isTenant search will be performed in tenant column
        // otherwise in renter

        Vector<Contract> results = new Vector<Contract>();
        Contract c;


        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement("select * from contract where ? = ? and expired = true";, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // unnecessary if rs is not scrolled

            if (isTenant) {
                stmt.setString(1, "tenant");
            } else { stmt.setString(1, "renter"); }
            stmt.setString(2, username);
            //stmt.setString(2, "'" + username + "'");
            System.out.println(stmt);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.first(); // is it worth it?

            while (rs.next()) {
                c = new Contract(
                        rs.getInt("id"),
                        rs.getString("renter"),
                        rs.getString("tenant"),
                        rs.getInt("apt"),
                        rs.getBoolean("expired")
                );
                results.add(c);
                System.out.println(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }*/
}
