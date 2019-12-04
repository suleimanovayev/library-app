package mate.academy.spring.controller;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InjectController {
    private static final Role USER = new Role("ROLE_USER");
    private static final Role ADMIN = new Role("ROLE_ADMIN");

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private RentService rentService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void injection() {
        Book bookTheHelp = new Book("The Help", 2010, 700D);
        Author authorKathrynStockett = new Author("Kathryn", "Stockett");
        bookTheHelp.getAuthors().add(authorKathrynStockett);
        authorKathrynStockett.getBooks().add(bookTheHelp);
        bookService.add(bookTheHelp);
        authorService.add(authorKathrynStockett);

        Book bookGreatExpectations = new Book("Great Expectations", 1986, 450D);
        Author authorCharlesDickens = new Author("Charles", "Dickens");
        bookGreatExpectations.getAuthors().add(authorCharlesDickens);
        authorCharlesDickens.getBooks().add(bookGreatExpectations);
        bookService.add(bookGreatExpectations);
        authorService.add(authorCharlesDickens);

        Book bookTheMagicOfReality = new Book("The Magic of Reality", 1999, 690D);
        Author authorRichardDawkins = new Author("Richard", "Dawkins");
        bookTheMagicOfReality.getAuthors().add(authorRichardDawkins);
        authorRichardDawkins.getBooks().add(bookTheMagicOfReality);
        bookService.add(bookTheMagicOfReality);
        authorService.add(authorRichardDawkins);

        roleService.add(USER);
        roleService.add(ADMIN);

        User user = new User("Maria","Maria","suleimanovayev@gmail.com");
        user.setPassword(passwordEncoder.encode("q"));
        user.setUsername("q");
        Role roleUser  = roleService.getRoleByName("ROLE_USER").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);
        user.setRoles(userRoles);
        userService.add(user);

        User admin = new User("Anna", "Anna", "arat@gmail.com");
        admin.setPassword(passwordEncoder.encode("a"));
        admin.setUsername("a");
        Role roleAdmin  = roleService.getRoleByName("ROLE_ADMIN").get();
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        admin.setRoles(adminRoles);
        userService.add(admin);
    }
}
