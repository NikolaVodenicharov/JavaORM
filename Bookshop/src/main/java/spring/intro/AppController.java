package spring.intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import spring.intro.entities.Book;
import spring.intro.entities.enums.AgeRestriction;
import spring.intro.entities.enums.Edition;
import spring.intro.repositories.AuthorRepository;
import spring.intro.repositories.BookRepository;
import spring.intro.services.AuthorServiceImpl;
import spring.intro.services.BookServiceImpl;
import spring.intro.services.CategoryServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;

@SpringBootApplication
@Component
public class AppController implements CommandLineRunner {
    private AuthorServiceImpl authorService;
    private BookServiceImpl bookService;
    private CategoryServiceImpl categoryService;

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public AppController(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryServiceImpl categoryService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var count = bookService.deleteAllByCopiesLessThan(300);
        System.out.println(count);
    }

    private void seedDatabase() throws Exception {
        this.authorService.seed();
        this.categoryService.seed();
        this.bookService.seed();
    }

    private void printBookTitleByAgeRestriction(){
        var line = readAgeRestriction();
        var ageRestriction = getAgeRestriction(line);
        var books = bookService.findAllByAgeRestriction(ageRestriction);
        var titles = getBooksTitles(books);

        System.out.println(titles);
    }
    private AgeRestriction getAgeRestriction(String inputAgeRestriction) {
        var upperCaseLine = inputAgeRestriction.toUpperCase();
        var restriction = AgeRestriction.valueOf(upperCaseLine);

        return restriction;
    }
    private String getBooksTitles(Collection<Book> books) {
        var builder = new StringBuilder();
        for(var book : books){
            builder
                .append(book.getTitle())
                .append(System.lineSeparator());
        }
        return builder.toString();
    }
    private String readAgeRestriction() {
        System.out.println("Please write age restriction");
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printGoldenBooksWithLessThan5000Copies(){
        var books = this.bookService.getTitlesByEditionsAndLessThanCopies(Edition.GOLD, 5000);
//        var titles = getBooksTitles(books);
        System.out.println(books);
    }


}
