package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.User;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    Optional<User> getByUserName(String userName);

    Optional<User> getByMail(String email);
}
