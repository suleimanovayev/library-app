package mate.academy.spring.service;

import mate.academy.spring.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
