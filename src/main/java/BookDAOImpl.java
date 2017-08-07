import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public class BookDAOImpl implements BookDAO {

    @Override
    public void createBook(Book b) {

        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO book (id, title, author) VALUES (?, ?, ?)");
            statement.setInt(1, b.getId());
            statement.setString(2, b.getTitle());
            statement.setString(3, b.getAuthor());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findBook(long id) {
        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, author FROM book WHERE id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            Book book = new Book();
            if(rs.next()) {
                book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"));
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
}

    @Override
    public void findBook(String isbn) {

    }

    @Override
    public List<Book> findBookByTitle(String title){
        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, author FROM book WHERE title LIKE ?");
            statement.setString(1, title + "%");
            ResultSet rs = statement.executeQuery();
            List<Book> booklist = new ArrayList<>();
            while(rs.next()) {
                booklist.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author")));
            }
            return booklist;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, author FROM book WHERE author LIKE ?");
            statement.setString(1,  "%"+ author + "%");
            ResultSet rs = statement.executeQuery();
            List<Book> booklist = new ArrayList<>();
            while(rs.next()) {
                booklist.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author")));
            }
            return booklist;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, author FROM book");
            ResultSet rs = statement.executeQuery();
            Book book = new Book();

            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                bookList.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author")));
            }
            return bookList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void saveBook(Book b) {
        return null;
    }

    @Override
    public int updateBook(Book b) {
        try (Connection connection = ConnectionFactory.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE book SET title =?, author=? WHERE id = ?");
            statement.setString(1,b.getTitle());
            statement.setString(2, b.getAuthor());
            statement.setInt(3, b.getId());
            return statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Void deleteBook(Book b) {
        return null;
    }
}
