
package mate.academy.spring;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User userSunil = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(userSunil);
        User userDavid = new User("David", "Miller", "david.miller@example.com");
        userService.add(userDavid);
        User userSameer = new User("Sameer", "Singh", "sameer.singh@example.com");
        userService.add(userSameer);
        User userPaul = new User("Paul", "Smith", "paul.smith@example.com");
        userService.add(userPaul);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);

        Book bookGranTorino = new Book("Гран Торино", 1987, 700D);
        Author authorNikShenk = new Author("Nik", "Shenk");
        bookService.add(bookGranTorino);
        authorService.add(authorNikShenk);
        bookGranTorino.setAuthors(Collections.singletonList(authorNikShenk));

        Book bookForrestGamp = new Book("Форрест Гамп", 1986, 450D);
        Author authorWinstonGroom = new Author("Winston", "Groom");
        bookService.add(bookForrestGamp);
        authorService.add(authorWinstonGroom);
        authorWinstonGroom.addBook(bookForrestGamp);
        bookForrestGamp.setAuthors(Collections.singletonList(authorWinstonGroom));

        Book bookGreenMile = new Book("Зеленая миля", 1999, 690D);
        Author authorStephenKing = new Author("Stephen", "King");
        bookService.add(bookGreenMile);
        authorService.add(authorStephenKing);
        bookGreenMile.setAuthors(Collections.singletonList(authorStephenKing));
        authorStephenKing.addBook(bookGreenMile);

        List<Book> bookList = bookService.listBooks();

        for (Book book : bookList) {
            System.out.println("Id = " + book.getId());
            System.out.println("Name = " + book.getName());
            System.out.println("Price = " + book.getPrice());
            System.out.println("Authors + " + book.getAuthors());
            System.out.println();
        }

        List<Author> authors = authorService.authors();

        for (Author author : authors) {
            System.out.println("Id = " + author.getId());
            System.out.println("Name = " + author.getName());
            System.out.println("Surname = " + author.getSurName());
            System.out.println("Books " + author.getBooks());

        }

        RentService rentService = context.getBean(RentService.class);

        rentService.add(new Rent(userSunil, bookGranTorino));
        rentService.add(new Rent(userSunil, bookForrestGamp));
        rentService.add(new Rent(userPaul, bookForrestGamp));
        rentService.add(new Rent(userDavid, bookGreenMile));

        rentService.getBooksRentByUser(userSunil);

        context.close();
    }
}
