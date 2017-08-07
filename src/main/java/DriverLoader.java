import java.sql.*;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public class DriverLoader {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","")) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS book");
            statement.execute("CREATE TABLE IF NOT EXISTS book(id INTEGER NOT NULL, title VARCHAR(255), author VARCHAR(255), PRIMARY KEY(id))");
            statement.execute("INSERT INTO book VALUES(1, 'The Expanse', 'JAMES SA Corey')");
            statement.execute("INSERT INTO book VALUES(2, 'Game of Thrones: Winds of Winter', 'GRR Martin')");
            statement.execute("INSERT INTO book VALUES(3, 'De Kapellekensbaan', 'Louis Paul Boon')");

            ResultSet rs = statement.executeQuery(
                    "SELECT id, title, author FROM book"
            );

            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                System.out.println("\nID: " + id + "\nTitle: " + title + "\nAuthor: " + author);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
