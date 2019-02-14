/*
 * Marco Cipriani (c) 2019.
 */

package dao;

import model.EvalApt;

import java.sql.*;
import java.util.Vector;

public class EvalAptDAO {

    private static EvalApt ea = null;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static Vector<EvalApt> results = new Vector<EvalApt>();

    public static Vector<EvalApt> findByUsr(String user) {

        try {
            conn = ConnectTools.getConnection();
            stmt = conn.createStatement();
            String query = "select * from \"EvalApt\" where \"evalusr\" = " + user;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                ea = new EvalApt(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("stars"),
                        rs.getBoolean("status"),
                        rs.getInt("aptid"),
                        rs.getString("owner"),
                        rs.getString("evalusr")
                );
                results.add(ea);
                System.out.println(ea);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            ConnectTools.closeConnection(stmt, conn);
        }
        return results;
    }

    public static EvalApt createEvalApt(String text, int stars, int aptid, String owner, String evalusr) {

        String query = "insert into \"EvalApt\" values "+
                text;

        return ea;
    }
}
