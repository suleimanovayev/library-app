package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void add(User user);

    List<User> listUsers();

    Optional<User> getByUserName(String userName);

    Optional<User> getByMail(String email);
}
