import java.util.List;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public class BooksApp {

    public static void main(String[] args) {
        BookDAO dao = new BookDAOImpl();
        dao.createBook(new Book(5, "Game of Games", "George R.R. Martin"));
        List<Book> books = dao.findBookByTitle("Game");
        books.forEach(System.out::println);
        Book entry1 = dao.findBook(3);
        System.out.println(entry1);
        List<Book> allBooks = dao.findAllBooks();
        allBooks.forEach(System.out::println);
        List<Book> bookByAuthor = dao.findBookByAuthor("R.R.");
        System.out.println();
        bookByAuthor.forEach(System.out::println);
        Book b = new Book(2, "Regendans", "Tjen Dekker");
        dao.updateBook(b);
        allBooks.forEach(System.out::println);
    }

}
