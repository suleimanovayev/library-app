package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {

    void add(Rent rent);

    List<Rent> rents();

    void returnBook(User user, Book book);

    Book getBookRentByUser(User user);
}
