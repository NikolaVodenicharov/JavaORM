package spring.intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import spring.intro.common.FileManager;
import spring.intro.entities.Author;
import spring.intro.entities.Book;
import spring.intro.entities.Category;
import spring.intro.entities.enums.AgeRestriction;
import spring.intro.entities.enums.Edition;
import spring.intro.repositories.AuthorRepository;
import spring.intro.repositories.BookRepository;
import spring.intro.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Primary
@Transactional
public class BookServiceImpl implements BookService {
    private FileManager fileManager;

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(FileManager fileManager, BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.fileManager = fileManager;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public void seed() throws Exception {
        if (this.bookRepository.count() > 0){
            return;
        }

        String booksPath = "C:\\Users\\WorkStation\\Desktop\\JavaORM\\Bookshop\\src\\main\\resources\\DummyDataInitializer\\books.txt";
        var lines = fileManager.readFile(booksPath);

        var random = new Random();

        var authorsCount = (int)this.authorRepository.count();
        var categoriesCount = (int)this.categoryRepository.count();

        for (var line : lines) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authorsCount - 1) + 1;
            Author author = this.authorRepository.findById(authorIndex).get();

            var editionType = Edition.values()[Integer.parseInt(data[0])];

            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);

            int copies = Integer.parseInt(data[2]);
            var price = new BigDecimal(data[3]);
            var ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            var title = this.getTitle(data);
            var categories = this.getCategories(random, categoriesCount);

            Book book = new Book();
            book.setAuthor(author);
            book.setEdition(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);

            this.save(book);
        }

    }
    private String getTitle(String[] data){
        StringBuilder titleBuilder = new StringBuilder();

        for (int i = 5; i < data.length; i++) {
            titleBuilder.append(data[i]).append(" ");
        }

        titleBuilder.delete(
                titleBuilder.lastIndexOf(" "),
                titleBuilder.lastIndexOf(" "));

        String title = titleBuilder.toString();

        return title;
    }
    private Set<Category> getCategories(Random random, int categoriesCount){
        var categories = new HashSet<Category>();

        if (categoriesCount == 0){
            return categories;
        }

        var categoriesCountToAdd = random.nextInt(2) + 1;
        var usedIndices = new HashSet<Integer>();

        for (var i = 1; i <= categoriesCountToAdd; i++){
            var categoryIndex = random.nextInt(categoriesCount - 1) + 1;

            if (usedIndices.contains(categoryIndex)){
                i--;
                continue;
            }

            usedIndices.add(categoryIndex);

            var category = categoryRepository.findById(categoryIndex).get();
            categories.add(category);
        }

        return categories;
    }

    public void save(Book book){
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> getTitlesByEditionsAndLessThanCopies(Edition edition, int copies) {
        return bookRepository.getTitlesByEditionsAndLessThanCopies(edition, copies);
    }

    @Override
    public long increaseCopiesByDate(Date date, int additionalCopies) {
        bookRepository.increaseCopiesByDate(date);

        var booksCountAfterDate = bookRepository.countAllByReleaseDateAfter(date);
        var totalIncrease = booksCountAfterDate * additionalCopies;

        return totalIncrease;
    }

    @Override
    public int deleteAllByCopiesLessThan(int copies) {
        var booksCount = bookRepository.countAllByCopiesLessThan(copies);
        bookRepository.deleteAllByCopiesLessThan(copies);

        return booksCount;
    }
}
