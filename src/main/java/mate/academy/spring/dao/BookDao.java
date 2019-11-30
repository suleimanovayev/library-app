package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;

public interface BookDao {

    void add(Book book);

    List<Book> listBooks();

    List<Book> findBookByTitle(String title);

    List<Book> findBooksByAuthor(String author);

    Optional<Book> find(Long id);

    void deleteBook(Long id);
}
