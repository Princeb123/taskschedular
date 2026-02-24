import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/task";
            String user = "postgres";
            String password = "35011956";

            conn = DriverManager.getConnection(url, user, password);

            System.out.println("PostgreSQL Connected!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
