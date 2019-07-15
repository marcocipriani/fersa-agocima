/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.Contract;

import java.sql.*;
import java.util.Vector;

public class ContractDAO {

    private static final String SEARCH_QUERY = "select * from \"Contract\" where ? = ?";

    private static Connection conn = null;
    private static Vector<Contract> results = new Vector<Contract>();
    private static PreparedStatement stmt = null;

    public static Vector<Contract> findByNickname(String nickname, boolean actualRole) {

        results = null;
        Contract c = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY);
            if (actualRole) {
                stmt.setString(1, "\"tenant\"");
            } else { stmt.setString(1, "\"renter\""); }
            stmt.setString(2, nickname);
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
}
