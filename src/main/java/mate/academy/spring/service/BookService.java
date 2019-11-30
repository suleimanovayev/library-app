package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    void add(Book book);

    List<Book> listBooks();

    List<Book> findBookByTitle(String name);

    List<Book> findBookByAuthor(String name);

    Optional<Book> find(Long id);

    void deleteBook(Long id);
}
