package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Author;

public interface AuthorService {

    void add(Author author);

    List<Author> authors();
}
