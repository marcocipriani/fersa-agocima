/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalApt;

import java.sql.*;
import java.util.Vector;

public class EvalAptDAO {

    private static final String READ_QUERY = "select * from \"EvalApt\" where \"evalusr\" = ?";
    private static final String CREATE_QUERY = "insert into \"EvalApt\" values (99,?,?,FALSE,?,?,?)";
    private static final String DELETE_QUERY = "delete from \"EvalApt\" where \"id\" = ?";

    private static Connection conn = null;
    private static Vector<EvalApt> results = new Vector<EvalApt>();

    public static Vector<EvalApt> findByUsr(String nickname) {

        PreparedStatement stmt = null;
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(READ_QUERY);
            stmt.setString(1, nickname);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                ea = new EvalApt(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getInt("aptid"),
                        rs.getString("owner"),
                        rs.getString("evalusr")
                );
                results.add(ea);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    // public static Vector<EvalApt> fin

    // TO_DO ritornare int di successo oppure -1
    public static void createEvalApt(String text, int stars, int aptid, String owner, String evalusr) {

        PreparedStatement stmt = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(CREATE_QUERY);
            stmt.setString(1, text);
            stmt.setInt(2, stars);
            stmt.setInt(3, aptid);
            stmt.setString(4, owner);
            stmt.setString(5, evalusr);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

    }

    public static void deleteEvalApt(int id) {

        PreparedStatement stmt = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }
    }
}
