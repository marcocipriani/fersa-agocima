/*
 * Marco Cipriani (c) 2019.
 */

package dao;


import model.ActualUsr;

import java.sql.*;

public class UsrDAO {

    private static final String SEARCH_QUERY = "select * from \"Usr\" where \"nickname\" = ? and where \"pwd\" = ?";
    private static final String BAD_QUERY = "select * from ( select * from \"Usr\" where \"reported\" = false ) where \"nickname\" = ? and where \"pwd\" = ?";

    private static Connection conn = null;

    public ActualUsr findByNickname(String nickname, String pwd, boolean isTenant) {

        PreparedStatement stmt = null;
        ActualUsr u = null;

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.prepareStatement(SEARCH_QUERY);
            stmt.setString(1, nickname);
            stmt.setString(2, pwd);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            u = new ActualUsr(
                rs.getString("nickname"),
                rs.getString("name"),
                rs.getArray("roles"),
                rs.getArray("aptlist"),
            );

            System.out.println(u);

            Array roles = rs.getArray("roles");
            String[] rolesToString = (String[])roles.getArray();

            if(isTenant && (rolesToString[1].equals("Tenant")))
                u.setActualRole(true);
                System.out.println("Sei un tenant");

        } catch (Exception e) { e.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        System.out.println(u);
        return u;

    }
}

