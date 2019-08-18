/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalApt;

import java.sql.*;
import java.util.Vector;

public class EvalAptDAO {

    private static final String SEARCH_AUTHOR_QUERY = "select * from \"EvalApt\" where \"evalusr\" = ?";
    private static final String SEARCH_OWNER_QUERY = "select * from \"EvalApt\" where \"owner\" = ?";
    private static final String CREATE_QUERY = "insert into \"EvalApt\" values (?,?,?,FALSE,?,?,?)";
    private static final String UPDATE_QUERY = "update \"EvalApt\" set \"text\" = ?, \"stars\" = ?, \"status\" = FALSE where \"id\" = ?";
    private static final String DELETE_QUERY = "delete from \"EvalApt\" where \"id\" = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    // valutazioni fatte da te
    public static Vector<EvalApt> findEvalMadeByYou(String nickname) {

        Vector<EvalApt> results = new Vector<EvalApt>();
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_AUTHOR_QUERY);
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
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    // valutazioni sui tuoi appartamenti
    public static Vector<EvalApt> findYourApts(String nickname) {

        Vector<EvalApt> results = new Vector<EvalApt>();
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_OWNER_QUERY);
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
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static void createEval(String text, int stars, int aptid, String owner, String evalusr) {

        Integer id = Indexing.askForIndex("EvalApt");

        try {
            conn = ConnectTools.getConnection();

            stmt = conn.prepareStatement(CREATE_QUERY);
            stmt.setInt(1, id);
            stmt.setString(2, text);
            stmt.setInt(3, stars);
            stmt.setInt(4, aptid);
            stmt.setString(5, owner);
            stmt.setString(6, evalusr);
            stmt.execute();
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

    }

    public static void updateEval(String text, int stars, int id) {

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

    public static void deleteEval(int id) {

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
