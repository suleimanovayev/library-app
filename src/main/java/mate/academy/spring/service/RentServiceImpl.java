package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> rents() {
        return rentDao.rents();
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }
}
