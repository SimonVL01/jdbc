import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public enum ConnectionFactory {
    INSTANCE;

    ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/books",
                    "root",
                    ""
            );
    }
}
