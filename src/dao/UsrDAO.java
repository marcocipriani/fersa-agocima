/*
 * Marco Cipriani (c) 2019.
 */

package dao;


import model.ActualUsr;

import java.sql.*;

public class UsrDAO {

    private static final String SEARCH_QUERY = "select * from \"Usr\" where \"nickname\" = ? and \"pwd\" = ?";
    private static final String TRUSTED_QUERY = "select * from \"Usr\" where \"nickname\" = ? and \"pwd\" = ? and \"reported\" = false";

    private static Connection conn = null;

    public static ActualUsr findByNickname(String nickname, String pwd, boolean isTenant) {

        PreparedStatement stmt = null;
        ActualUsr u = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, nickname);
            stmt.setString(2, pwd);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            
            rs.first();
            String nick = rs.getString("nickname");
            String name = rs.getString("name");
            String pass = rs.getString("pwd");
            int roles = rs.getInt("roles");
            boolean reported = rs.getBoolean("reported");
            u = new ActualUsr(nick, name, pass, roles, reported, false);

            if(isTenant) {
                u.setActualRole(true);
                System.out.println("Sei un proprietario");
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return u;

    }
}

