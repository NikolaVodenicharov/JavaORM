package spring.intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import spring.intro.services.AuthorServiceImpl;
import spring.intro.services.BookServiceImpl;
import spring.intro.services.CategoryServiceImpl;

@SpringBootApplication
@Component
public class AppController implements CommandLineRunner {
    private AuthorServiceImpl authorService;
    private BookServiceImpl bookService;
    private CategoryServiceImpl categoryService;

    @Autowired
    public AppController(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryServiceImpl categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedDatabase();
    }

    private void seedDatabase() throws Exception {
        this.authorService.seed();
        this.categoryService.seed();
        this.bookService.seed();
    }
}
