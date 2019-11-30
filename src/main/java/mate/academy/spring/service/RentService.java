package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface RentService {
    void add(Rent rent);

    List<Rent> rents();

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);

    Rent rentBook(User user, Book book);
}
