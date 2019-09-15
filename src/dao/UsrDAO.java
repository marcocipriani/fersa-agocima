/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.ActualUsr;

import java.sql.*;

public class UsrDAO {

    private static final String SEARCH_QUERY = "select * from Usr where username = ? and pwd = ?";
    private static final String TRUSTED_QUERY = "select * from Usr where username = ? and pwd = ? and reported = false";

    private static Connection conn = null;

    public static ActualUsr findByUsername(String username, String pwd, boolean isTenant) {

        PreparedStatement stmt = null;
        ActualUsr u = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            
            rs.first();
            String user = rs.getString("username");
            String name = rs.getString("name");
            String pass = rs.getString("pwd");
            int roles = rs.getInt("roles");
            boolean reported = rs.getBoolean("reported");
            u = new ActualUsr(user, name, pass, roles, reported, false);



            if(isTenant && (roles == 1 || roles == 2)){
                u.setActualRole(true);
                System.out.println("@UsrDAO - Sei un proprietario tenant");
            } else if (!isTenant && (roles == 0)){
                System.out.println("@UsrDAO - Sei un inquilino renter");
            } else {
                System.out.println("@UsrDAO - Non hai i privilegi necessari");
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return u;

    }
}

