/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.Contract;

import java.sql.*;
import java.util.Vector;

public class ContractDAO {

    private static final String SEARCH_QUERY = "select * from contract where ? = ? and expired = true";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    public static Vector<Contract> findReadyToEvaluate(String nickname, boolean actualRole) {
        // if actualRole == true, search will be performed in tenant column
        // otherwise in renter

        Vector<Contract> results = new Vector<Contract>();
        Contract c;


        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                                        // unnecessary if rs is not scrolled

            if (actualRole) {
                stmt.setString(1, "tenant");
            } else { stmt.setString(1, "renter"); }
            stmt.setString(2, "'" + nickname + "'");
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
    }
}
