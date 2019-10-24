package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Override
    public Book findBookByTitle(String name) {
        return bookDao.findBookByTitle(name);
    }

    @Override
    public Book findBookByAuthor(String name) {
        return bookDao.findBookByTitle(name);
    }
}
