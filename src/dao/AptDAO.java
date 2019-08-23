/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.Apt;

import java.sql.*;
import java.util.Vector;

public class AptDAO {

    private static final String SEARCH_ID_QUERY = "select * from Apt where \"id\" = ?";
    private static final String SEARCH_ADDRESS_QUERY = "select * from Apt where \"address\" = ?";
    private static final String SEARCH_OWNER_QUERY = "select * from Apt where \"owner\" = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    public static Apt findByID(Integer id) {

        Apt a = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_ID_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.first();
            int aptId = rs.getInt("id");
            String owner = rs.getString("owner");
            String addr = rs.getString("address");
            a = new Apt(aptId, owner, addr);

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return a;
    }

    public static Vector<Apt> findByAddress(String address) {

        Vector<Apt> results = new Vector<Apt>();
        Apt a = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_ADDRESS_QUERY);
            stmt.setString(1, address);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                a = new Apt(
                        rs.getInt("id"),
                        rs.getString("owner"),
                        rs.getString("address")
                );
                results.add(a);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static Vector<Apt> findByOwner(String nickname) {

        Vector<Apt> results = new Vector<Apt>();
        Apt a = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_OWNER_QUERY);
            stmt.setString(1, nickname);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                a = new Apt(
                        rs.getInt("id"),
                        rs.getString("owner"),
                        rs.getString("address")
                );
                results.add(a);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }
}
