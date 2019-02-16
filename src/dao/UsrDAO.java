/*
 * Marco Cipriani (c) 2019.
 */

package dao;


import model.ActualUsr;

import java.sql.*;

public class UsrDAO {

    private static final String SEARCH_QUERY = "select * from \"Usr\" where \"nickname\" = ? and \"pwd\" = ?";
    private static final String BAD_QUERY = "select * from ( select * from \"Usr\" where \"reported\" = false ) where \"nickname\" = ? and where \"pwd\" = ?";

    private static Connection conn = null;

    public static ActualUsr findByNickname(String nickname, String pwd, boolean isTenant) {

        PreparedStatement stmt = null;
        ActualUsr u = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nickname);
            stmt.setString(2, pwd);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            if (!rs.first()) // rs not empty
                return null;

            boolean moreThanOne = rs.first() && rs.next();

            rs.first();

            String first = rs.getString("nickname");
            String second = rs.getString("name");
            int third = rs.getInt("roles");


            // dummy aptlist
            int[] aptlist = new int[2];
            aptlist[0]=101;

            rs.first();
            u = new ActualUsr(
                first, second, third, aptlist
            );

            int roles = u.getRoles();

            if(isTenant) {
                u.setActualRole(true);
                System.out.println("Sei un proprietario"); }

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        System.out.println(u);
        return u;

    }
}

