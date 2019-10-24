package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> authors() {
        return authorDao.authors();
    }
}
