package mate.academy.spring.controller;

import java.security.Principal;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/rentbook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model, Principal principal) {
        Optional<User> optionalUser = userService.getByMail(principal.getName());
        if (optionalUser.isEmpty()) {
            return "wrong";
        }
        User user = optionalUser.get();
        Optional<Book> optionalBook = bookService.find(bookId);
        if (optionalBook.isEmpty()) {
            return "wrong";
        }
        Book book = optionalBook.get();
        Rent rent = rentService.rentBook(user, book);
        model.addAttribute("rent", rent);
        return "forward:/book";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("book_id") Long bookId, Principal principal) {
        Optional<User> optionalUser = userService.getByMail(principal.getName());
        if (optionalUser.isEmpty()) {
            return "error";
        }
        User user = optionalUser.get();
        Optional<Book> optionalBook = bookService.find(bookId);
        if (optionalBook.isEmpty()) {
            return "error";
        }
        Book book = optionalBook.get();
        rentService.returnBook(user, book);
        return "forward:/book";
    }

    @GetMapping("/rent")
    public String rentBooks(Model model, Principal principal) {
        Optional<User> optionalUser = userService.getByMail(principal.getName());
        if (optionalUser.isEmpty()) {
            return "error";
        }
        User user = optionalUser.get();
        List<Book> booksRentByUser = rentService.getBooksRentByUser(user);
        model.addAttribute("rentBooks", booksRentByUser);
        return "rentInfo";
    }
}
