
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
        User user1 = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(user1);
        User user2 = new User("David", "Miller", "david.miller@example.com");
        userService.add(user2);
        User user3 = new User("Sameer", "Singh", "sameer.singh@example.com");
        userService.add(user3);
        User user4 = new User("Paul", "Smith", "paul.smith@example.com");
        userService.add(user4);

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

        Book book1 = new Book("Гран Торино", 1987, 700D);
        Author author1 = new Author("Nik", "Shenk");
        bookService.add(book1);
        authorService.add(author1);
        book1.setAuthors(Collections.singletonList(author1));

        Book book2 = new Book("Форрест Гамп", 1986, 450D);
        Author author2 = new Author("Winston", "Groom");
        bookService.add(book2);
        authorService.add(author2);
        author2.addBook(book2);
        book2.setAuthors(Collections.singletonList(author2));

        Book book3 = new Book("Зеленая миля", 1999, 690D);
        Author author3 = new Author("Stephen", "King");
        bookService.add(book3);
        authorService.add(author3);
        book3.setAuthors(Collections.singletonList(author3));
        author3.addBook(book3);

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

        Rent rent1 = new Rent(user1, book1);
        Rent rent2 = new Rent(user2, book2);
        Rent rent3 = new Rent(user3, book3);

        rentService.add(rent1);
        rentService.add(rent2);
        rentService.add(rent3);

        context.close();
    }
}
