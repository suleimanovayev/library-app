package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import mate.academy.spring.service.AuthorService;
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

    @Transactional
    @Override
    public Optional<Author> getById(Long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return null;
    }
}
