package mate.academy.spring.dao;

import java.util.List;
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
        TypedQuery typedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Rent, Rent.class");
        return typedQuery.getResultList();
    }

    @Override
    public void returnBook(User user, Book book) {
        TypedQuery typedQuery = sessionFactory
                .getCurrentSession()
                .createQuery("update Rent set active = false where"
                + " user_id=:user_id and book_id=:book_id");
        typedQuery.setParameter("user_id", user.getId());
        typedQuery.setParameter("book_id", book.getId());
        typedQuery.executeUpdate();
    }

    @Override
    public Book getBookRentByUser(User user) {
        TypedQuery typedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Rent where user=:user");
        return (Book) typedQuery.getSingleResult();
    }
}
