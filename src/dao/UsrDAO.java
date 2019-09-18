/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.ActualUsr;
import model.Usr;

import java.sql.*;


public class UsrDAO {

    private static final String FIND_QUERY = "select * from usr where username = ? and pwd = ?";
    private static final String TRUSTED_QUERY = "select * from usr where username = ? and pwd = ? and reported = false";
    private static final String SEARCH_QUERY = "select * from usr where username = ?";
    private static final String DETAILS_QUERY = "select name from usr where username = ?";

    private static Connection conn = null;
    private static PreparedStatement stmt = null;

    public static ActualUsr findByUsername(String username, String pwd, boolean isTenant) {

        ActualUsr au = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(FIND_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            if (!rs.first())
                return null;
            boolean moreThanOne = rs.first() && rs.next();
            rs.first();
            //rs.next(); // ok only if hit

            String user = rs.getString("username");
            String name = rs.getString("name");
            String pass = rs.getString("pwd");
            int roles = rs.getInt("roles");
            boolean reported = rs.getBoolean("reported");
            au = new ActualUsr(user, name, pass, roles, reported, false);


        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return au;

    }

    public static Usr searchByUsername(String username){
        Usr u = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            if (!rs.first())
                return null;
            boolean moreThanOne = rs.first() && rs.next();
            rs.first();
            //rs.next(); // ok only if hit

            String user = rs.getString("username");
            String name = rs.getString("name");
            String pass = rs.getString("pwd");
            int roles = rs.getInt("roles");
            boolean reported = rs.getBoolean("reported");
            u = new Usr(user, name, pass, roles, reported);

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return u;
    }

    public static String getUsrDetails(String username){

        String name = "";

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.next();
            name = rs.getString("name");

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return name;
    }
}

