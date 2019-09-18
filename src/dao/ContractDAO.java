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
    private static final String GET_DETAILS_QUERY = "select renter, tenant, apt from contract where id = ?";

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

    //TODO sostituire questa alle versioni singole
    public static Vector<Contract> findYourContracts(String username, boolean isTenant, boolean isExpired) {
        // if isTenant search will be performed in tenant column
        // otherwise in renter

        Vector<Contract> results = new Vector<Contract>();
        Contract c;
        String colName, expiredString;
        if (isTenant) {
            colName = "tenant";
        } else { colName = "renter"; }
        if (isExpired) {
            expiredString = "true";
        } else { expiredString = "false"; }
        String searchQuery = "select * from contract where " + colName + " = '" + username + "' and expired = " + expiredString;


        try {
            conn = ConnectTools.getConnection();
            Statement stmt2 = conn.createStatement();
            // unnecessary if rs is not scrolled


            System.out.println(searchQuery);

            stmt2.execute(searchQuery);
            ResultSet rs = stmt2.getResultSet();

            //rs.first(); // is it worth it?

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

    public static Vector getDetails(int id){

        Vector result = new Vector(3);

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(GET_DETAILS_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                                            // unnecessary if rs is not scrolled
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            //rs.first(); // is it worth it?

            rs.first();
            result.add(0, rs.getString("renter"));
            result.add(1, rs.getString("tenant"));
            result.add(2, rs.getInt("apt"));



        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return result;
    }

}
