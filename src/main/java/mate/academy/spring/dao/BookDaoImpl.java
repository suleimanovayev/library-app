package mate.academy.spring.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
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
        return query.getResultList();
    }

    @Override
    public Book findBookByTitle(String title) {
        TypedQuery typedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Book where "
                        + "title like concat('%', :title, '%')", Book.class);
        typedQuery.setParameter("title", title);
        return (Book) typedQuery.getSingleResult();
    }
}
