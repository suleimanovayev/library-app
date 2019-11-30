package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> authors() {
        TypedQuery<Author> authorTypedQuery = sessionFactory.getCurrentSession()
                .createQuery("from Author", Author.class);
        return authorTypedQuery.getResultList();
    }

    @Override
    public Optional<Author> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Author> findByName(String name) {
        return null;
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return null;
    }
}
