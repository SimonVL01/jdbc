import java.util.List;

/**
 * Created by vdabcursist on 07/08/2017.
 */
public interface BookDAO {
    Book findBook(long id);

    void findBook(String isbn);

    List<Book> findBookByTitle(String category);

    public List<Book> findBookByAuthor(String author);

    public List<Book> findAllBooks();

    public void createBook(Book b);

    public Void saveBook(Book b);

    public int updateBook(Book b);

    public Void deleteBook(Book b);
}
