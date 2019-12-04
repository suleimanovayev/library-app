package mate.academy.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RentService;
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
        rentDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }

    @Transactional
    @Override
    public void rentBook(User user, Book book) {
        Rent rent  = new Rent();
        rent.setBook(book);
        rent.setUser(user);
        rent.setActive(true);
        rentDao.add(rent);
    }
}
