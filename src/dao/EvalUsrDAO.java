/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalUsr;
import java.sql.*;
import org.postgresql.util.PSQLException;
import java.util.Vector;

public class EvalUsrDAO {

    private static final String SEARCH_AUTHOR_QUERY = "select * from evalusr where evalusr = ?";
    private static final String SEARCH_USERNAME_QUERY = "select * from evalusr where username = ?";
    private static final String SEARCH_ID_QUERY = "select * from evalusr where id = ?";

    private static final String CREATE_QUERY = "insert into evalusr values (?,?,?,true,?,?,?)";
    private static final String UPDATE_QUERY = "update evalusr set text = ?, stars = ?, status = true where id = ?";
    private static final String DELETE_QUERY = "delete from evalusr where id = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    // evaluations where evalusr is your username
    public static Vector<EvalUsr> findEvalMadeByYou(String username) {

        Vector<EvalUsr> results = new Vector<>();
        EvalUsr eu;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_AUTHOR_QUERY);
            stmt.setString(1, username);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                eu = new EvalUsr(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getString("username"),
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
                results.add(eu);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    // evaluations where username is your username
    public static Vector<EvalUsr> findEvalAboutYou(String username) {

        Vector<EvalUsr> results = new Vector<>();
        EvalUsr eu = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_USERNAME_QUERY);
            stmt.setString(1, username);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                eu = new EvalUsr(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getString("username"),
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
                results.add(eu);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static EvalUsr findById(int id){

        EvalUsr ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_ID_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()) {
                ea = new EvalUsr(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getString("username"),
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
            }
        } catch (PSQLException psqle) { psqle.printStackTrace(); } //TODO sistemare eccezioni
        catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return ea;
    }

    public static void createEval(String text, int stars, String username, String evalusr, int contractid) {

        Integer id = Indexing.askForIndex("EvalUsr");

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(CREATE_QUERY);
            stmt.setInt(1, id);
            stmt.setString(2, text);
            stmt.setInt(3, stars);
            stmt.setString(4, username);
            stmt.setString(5, evalusr);
            stmt.setInt(6, contractid);
            stmt.executeUpdate();
            System.out.println("@EvalUsrDAO > createEval - " + stmt);
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
            System.out.println("@EvalUsrDAO > updateEval - " + stmt);
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }
    }

    public static void deleteEval(int id) {

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("@EvalUsrDAO > deleteEval - " + stmt);
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }
    }

}