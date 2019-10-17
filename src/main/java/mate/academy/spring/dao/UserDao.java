package mate.academy.spring.dao;

import mate.academy.spring.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
