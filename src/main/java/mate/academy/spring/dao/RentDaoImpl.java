package mate.academy.spring.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public List<Rent> rents() {
        TypedQuery<Rent> typedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Rent", Rent.class);
        return typedQuery.getResultList();
    }

    @Override
    public void returnBook(User user, Book book) {
        TypedQuery<Query> typedQuery = sessionFactory
                .getCurrentSession()
                .createQuery("update Rent set active = false where"
                + " user_id=:user_id and book_id=:book_id");
        typedQuery.setParameter("user_id", user.getId());
        typedQuery.setParameter("book_id", book.getId());
        typedQuery.executeUpdate();
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Book> typedQuery = sessionFactory.getCurrentSession()
                .createQuery("select rent.book from Rent "
                        + "rent where user_id=:userId and active = true", Book.class);
        typedQuery.setParameter("userId", user.getId());
        return typedQuery.getResultList();
    }
}
