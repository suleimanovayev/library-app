package mate.academy.spring.controller;

import java.security.Principal;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @GetMapping("/rentBook")
    public String getAllBooksRentByUser(ModelMap model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        if (optionalUser.isEmpty()) {
            model.addAttribute("message", "User not found");
            return "errorPage";
        }
        model.put("books", rentService.getBooksRentByUser(optionalUser.get()));
        return "rentByUser";
    }

    @GetMapping("/getBook")
    public String rentBook(@RequestParam("book_id") Long id, ModelMap model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        Optional<Book> optionalBook = bookService.find(id);
        if (optionalUser.isEmpty() || optionalBook.isEmpty()) {
            model.addAttribute("message", "Failed to rent a book with id = " + id);
            return "errorPage";
        }
        rentService.rentBook(optionalUser.get(), optionalBook.get());
        return getAllBooksRentByUser(model,principal);
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("book_id") Long id,
                             ModelMap model, Principal principal) {
        Optional<User> optionalUser = getCurrentUser(principal);
        Optional<Book> optionalBook = bookService.find(id);
        if (optionalUser.isEmpty() || optionalBook.isEmpty()) {
            model.addAttribute("message", "Failed to return a book with id = " + id);
            return "errorPage";
        }
        rentService.returnBook(optionalUser.get(), optionalBook.get());
        return getAllBooksRentByUser(model,principal);
    }

    private Optional<User> getCurrentUser(Principal principal) {
        return userService.getByUserName(principal.getName());
    }
}
