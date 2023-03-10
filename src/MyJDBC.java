import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MyJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USERdeveloper = "root";
            String password = "AlessandroCalabrese";

            conn = DriverManager.getConnection(DB_URL, USERdeveloper, password);
            System.out.println("Connection successful");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE_SQL);
            stmt.executeUpdate(INSERT_DATA_SQL);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    static String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS student (" +
            "student_id INT(10) NOT NULL AUTO_INCREMENT, " +
            "last_name VARCHAR(30)," +
            "first_name VARCHAR(30)," +
            "PRIMARY KEY (student_id))";
    static String INSERT_DATA_SQL = "INSERT INTO student (last_name, first_name) VALUES" +
            "('Alessandro', 'Calabrese'), " +
            "('Pippo', 'Baudo'), " +
            "('Mario', 'Rossi'), " +
            "('Paolo', 'Maldini')";
}