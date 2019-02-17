/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalUsr;

import java.sql.*;
import java.util.Vector;

public class EvalUsrDAO {

    private static final String SEARCH_AUTHOR_QUERY = "select * from \"EvalUsr\" where \"evalusr\" = ?";
    private static final String SEARCH_NICKNAME_QUERY = "select * from \"EvalUsr\" where \"nickname\" = ?";
    private static final String CREATE_QUERY = "insert into \"EvalUsr\" values (99,?,?,FALSE,?,?)";
    private static final String UPDATE_QUERY = "update \"EvalUsr\" set \"text\" = ?, \"stars\" = ?, \"status\" = FALSE where \"id\" = ?";
    private static final String DELETE_QUERY = "delete from \"EvalUsr\" where \"id\" = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    // valutazioni fatte da te
    public static Vector<EvalUsr> findEvalMadeByYou(String nickname) {

        Vector<EvalUsr> results = new Vector<EvalUsr>();
        EvalUsr eu = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_AUTHOR_QUERY);
            stmt.setString(1, nickname);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                eu = new EvalUsr(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getString("nickname"),
                        rs.getString("evalusr")
                );
                results.add(eu);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    // valutazioni su di te
    public static Vector<EvalUsr> findYourEvals(String nickname) {

        Vector<EvalUsr> results = new Vector<EvalUsr>();
        EvalUsr eu = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_NICKNAME_QUERY);
            stmt.setString(1, nickname);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                eu = new EvalUsr(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getString("nickname"),
                        rs.getString("evalusr")
                );
                results.add(eu);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static void createEvalUsr(String text, int stars, String nickname, String evalusr) {

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(CREATE_QUERY);
            stmt.setString(1, text);
            stmt.setInt(2, stars);
            stmt.setString(3, nickname);
            stmt.setString(4, evalusr);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

    }

    public static void updateEvalUsr(String text, int stars, int id) {

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, text);
            stmt.setInt(2, stars);
            stmt.setInt(3, id);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

    }

    public static void deleteEvalUsr(int id) {

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

    }
    // TO_DO ritornare int di successo oppure -1
}
