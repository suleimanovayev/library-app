
package mate.academy.spring.dao;

import mate.academy.spring.entity.Book;

import java.util.List;

public interface BookDao {

    void add(Book book);

    List<Book> listBooks();
}
