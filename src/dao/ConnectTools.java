/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import java.sql.*;

public class ConnectTools {

    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/agocimadb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "galaxy070592";

    private static Connection conn = null;

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        }
        catch (Exception e) { e.printStackTrace(); }

        return conn;
    }

    public static void closeConnection(Statement stmt, Connection conn){
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se) { se.printStackTrace(); }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) { se.printStackTrace(); }
    }
}
