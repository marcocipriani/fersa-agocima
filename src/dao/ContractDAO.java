/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.Contract;

import java.sql.*;
import java.util.Vector;

public class ContractDAO {

    private static final String SEARCH_QUERY = "select * from Contract where \"expired\" = true"; // where ? = ? and

    private static Connection conn = null;
    private static Statement stmt = null; //Prepared

    public static Vector<Contract> findByNickname(String nickname, boolean actualRole) {

        Vector<Contract> results = new Vector<Contract>();
        Contract c;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            /*stmt = conn.prepareStatement(SEARCH_QUERY);

            if (actualRole) {
                stmt.setString(1, "\"tenant\"");
            } else { stmt.setString(1, "\"renter\""); }

            stmt.setString(2, "\'" + nickname + "\'");
            stmt.execute();*/

            ResultSet rs = stmt.executeQuery(SEARCH_QUERY);

            if (!rs.first())
            return null;

            boolean moreThanOne = rs.first() && rs.next();
            assert !moreThanOne;
            rs.first();

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
