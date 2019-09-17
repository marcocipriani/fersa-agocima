/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalApt;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.Vector;

public class EvalAptDAO {

    private static final String SEARCH_AUTHOR_QUERY = "select * from EvalApt where evalusr = ?";
    private static final String SEARCH_OWNER_QUERY = "select * from EvalApt where owner = ?";
    private static final String SEARCH_ADDRESS_QUERY = "select evalapt.id, text, stars, status, aptid, evalapt.owner, evalusr, address, contractid from EvalApt join Apt on evalapt.aptid = apt.id where status = true and address = ?";
    private static final String SEARCH_ID_QUERY = "select * from EvalApt where id = ?";
    private static final String CREATE_QUERY = "insert into EvalApt values (?,?,?,FALSE,?,?,?,?)";
    private static final String UPDATE_QUERY = "update EvalApt set text = ?, stars = ?, status = FALSE where id = ?";
    private static final String DELETE_QUERY = "delete from EvalApt where id = ?";
    private static final String AVG_QUERY = "select avg(stars) from EvalApt where aptid = ? and status = true";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    // evaluations where evalusr is username
    public static Vector<EvalApt> findEvalMadeByYou(String username) {

        Vector<EvalApt> results = new Vector<EvalApt>();
        EvalApt ea;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_AUTHOR_QUERY);
            stmt.setString(1, username);
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
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
                results.add(ea);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    // only for tenant
    // evaluations where owner is username
    public static Vector<EvalApt> findYourApts(String username) {

        Vector<EvalApt> results = new Vector<EvalApt>();
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_OWNER_QUERY);
            stmt.setString(1, username);
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
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
                results.add(ea);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static Vector<EvalApt> findByAddress(String address){
        Vector<EvalApt> results = new Vector<EvalApt>();
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_ADDRESS_QUERY);
            stmt.setString(1, address);
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
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
                results.add(ea);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return results;
    }

    public static EvalApt findById(int id){
        EvalApt ea = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_ID_QUERY);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()) {
                ea = new EvalApt(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getInt("aptid"),
                        rs.getString("owner"),
                        rs.getString("evalusr"),
                        rs.getInt("contractid")
                );
            }
        } //TODO intercept NullPointerException
        catch (Exception e) { e.getStackTrace(); System.out.println("@EvalAptDAO.java - ID non corretto"); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return ea;
    }

    //TODO test as boolean or make it void
    public static void createEval(String text, int stars, int aptid, String owner, String evalusr, int contractid) {

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
            stmt.setInt(7, contractid);
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

    public static double getAvg(int aptid){
        Double avg = 0.0;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(AVG_QUERY);
            stmt.setInt(1, aptid);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            if(rs.next()) {
                avg = rs.getDouble("avg");
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return avg;
    }

}
