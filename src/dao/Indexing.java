package dao;

import java.sql.*;

public class Indexing {

    private static Integer index;
    private static Connection conn = null;
    private static Statement stmt = null;

    public static Integer askForIndex(String table){

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select id from " + table + " order by id desc LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.first()) // rs not empty
                return null;

            boolean moreThanOne = rs.first() && rs.next();
            assert !moreThanOne;
            rs.first();

            index = rs.getInt("id");
            index ++;

        } catch (SQLException se) { System.out.println("Errore in SQL askForIndex"); se.printStackTrace(); }
        finally { ConnectTools.closeConnection(stmt, conn); }

        return index;
    }
}