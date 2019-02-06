/*
 * Marco Cipriani (c) 2019.
 */

/*
 * Marco Cipriani (c) 2019.
 */

import java.sql.*;

public class EvalDao {
    private static String URL = "jdbc:postgresql://127.0.0.1:56940/agocimadb";
    private static String DRIVER_CLASS_NAME = "org.postgresql.Driver";

    public static Eval findByStars(int star) {
        Statement stmt = null;
        Connection conn = null;
        Eval e = null;

        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(URL, "postgres", "postgres");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT id, text, stars, status FROM EvalTable where stars = '" + star + "';";
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.first())
                return null;

            rs.first(); // posizionamento sul primo elemento
            int id = rs.getInt("id");
            String text = rs.getString("text");
            int stars = rs.getInt("stars");
            int status = rs.getInt("status");

            e = new Eval(id, text, stars, status);
            System.out.println(e);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception ce) { // ce = common error, distinguere da Eval e
            ce.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return e;
    }
}
