package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Book", Book.class);
        List<Book> a = query.getResultList();
        return a;
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        TypedQuery<Book> typedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Book where "
                        + "title like concat('%', :title, '%')", Book.class);
        typedQuery.setParameter("title", title);
        return typedQuery.getResultList();
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        NativeQuery<Book> sqlQuery = sessionFactory
                .getCurrentSession()
                .createSQLQuery("SELECT * FROM books inner join "
                        + "books_authors on books.id = book_authors.book_id "
                        + "inner join authors on books_authors.authors_id = authors"
                        + ".id where authors.name like concat('%', " + author + ", '%');");
        sqlQuery.setParameter("author", author);
        return sqlQuery.getResultList();
    }

    @Override
    public Optional<Book> find(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Book.class, id));
    }

    @Override
    public void deleteBook(Long bookId) {
        TypedQuery<Book> typedQuery = sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Book WHERE book_id=:book_id");
        typedQuery.setParameter("book_id", bookId);
        typedQuery.executeUpdate();
    }
}
