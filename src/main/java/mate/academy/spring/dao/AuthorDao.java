package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Author;

public interface AuthorDao {

    void add(Author author);

    List<Author> authors();

    Optional<Author> getById(Long id);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
