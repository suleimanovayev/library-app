package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
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

    @Transactional
    @Override
    public List<Book> findBookByTitle(String name) {
        return bookDao.findBookByTitle(name);
    }

    @Transactional
    @Override
    public List<Book> findBookByAuthor(String name) {
        return bookDao.findBooksByAuthor(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> find(Long id) {
        return bookDao.find(id);
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }
}
