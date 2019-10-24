package mate.academy.spring.dao;

import java.util.List;
import javax.persistence.TypedQuery;
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
                .createQuery("from Author, Author.class");
        return authorTypedQuery.getResultList();
    }
}
