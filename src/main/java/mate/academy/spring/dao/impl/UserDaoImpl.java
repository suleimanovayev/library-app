package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public Optional<User> getByUserName(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User where username=:username",
                        User.class);
        query.setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<User> getByMail(String email) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(User.class, email));
    }
}
