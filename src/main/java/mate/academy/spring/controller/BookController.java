package mate.academy.spring.controller;

import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") Long id, Model model) {
        Optional<Book> optionalBook = bookService.find(id);
        model.addAttribute("book", optionalBook.get());
        return "bookInfo";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "addBook";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", bookService.findBookByTitle(title));
        return "allBooks";
    }
}
