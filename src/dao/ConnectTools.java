/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import java.io.*;
import java.sql.*;

public class ConnectTools {

    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/agocimadb";
    private static final String USER = "postgres";
    private static final String PASSWORD = getPassword(); // retrieve pwd from pwd.txt in root project directory

    private static Connection conn = null;

    public static Connection getConnection(){
        // to log the password used // System.out.println("Password: " + PASSWORD);
        try {
            Class.forName(DRIVER_CLASS_NAME); // at runtime asks loading the class to the ClassLoader
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false); // prevent connection from close automatically

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

    public static String getPassword(){
        BufferedReader in = null;
        String s = null;

        try {
            in = new BufferedReader( new FileReader("pwd.txt"));
        } catch (FileNotFoundException fnfe) { System.out.println("File pwd.txt not found\n"); fnfe.printStackTrace(); }


        try {
            s = in.readLine();
            in.close();
        } catch (Exception e) { System.out.println("Error in reading pwd.txt\n"); e.printStackTrace(); }

        return s;
    }

}
