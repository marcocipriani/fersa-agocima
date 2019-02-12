/*
 * Marco Cipriani (c) 2019.
 */

import model.EvalApt;

import java.sql.*;

public class EvalAptDAO {

    private static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql://localhost:5432/agocimadb";
    private static String USER = "postgres";
    private static String PASSWORD = "postgres";


    public static EvalApt findByUsr(String user) {

        Statement stmt = null;
        Connection conn = null;
        EvalApt ea = null;

        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            stmt = conn.createStatement();

            String query = "select * from \"EvalApt\" where \"evalusr\" = " + user;
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                System.out.println(id);
                String text = rs.getString("text");
                System.out.println(text);
                int stars = rs.getInt("stars");
                System.out.println(stars);
                boolean status = rs.getBoolean("status");
                System.out.println(status);
                int aptid = rs.getInt("aptid");
                System.out.println(aptid);
                String owner = rs.getString("owner");
                System.out.println(owner);
                String evalusr = rs.getString("evalusr");
                System.out.println(evalusr);

                ea = new EvalApt(text, stars, aptid, owner, evalusr);
                System.out.println(ea);



            }


        }
        catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) { se.printStackTrace(); }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) { se.printStackTrace(); }
        }

        return ea;

    }
}
