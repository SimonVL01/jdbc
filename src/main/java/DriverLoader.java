import java.sql.SQLException;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public class DriverLoader {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
