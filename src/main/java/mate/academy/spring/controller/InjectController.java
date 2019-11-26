package mate.academy.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private RentService rentService;

    @PostConstruct
   public void injection() {
        List<Author> authors = new ArrayList<>();
        Book bookTheHelp = new Book("The Help", 2010, 700D);
        Author authorKathrynStockett = new Author("Kathryn", "Stockett");
        bookService.add(bookTheHelp);
        authors.add(authorKathrynStockett);
        bookTheHelp.setAuthors(authors);
        authorKathrynStockett.getBooks().add(bookTheHelp);

        Book bookGreatExpectations = new Book("Great Expectations", 1986, 450D);
        Author authorCharlesDickens = new Author("Charles", "Dickens");
        bookService.add(bookGreatExpectations);
        authorService.add(authorCharlesDickens);
        bookGreatExpectations.setAuthors(Collections.singletonList(authorCharlesDickens));
        authorCharlesDickens.getBooks().add(bookGreatExpectations);

        Book bookTheMagicOfReality = new Book("The Magic of Reality", 1999, 690D);
        Author authorRichardDawkins = new Author("Richard", "Dawkins");
        bookService.add(bookTheMagicOfReality);
        authorService.add(authorRichardDawkins);
        bookTheMagicOfReality.setAuthors(Collections.singletonList(authorRichardDawkins));
        authorRichardDawkins.getBooks().add(bookTheMagicOfReality);
    }
}
