package spring.intro.services;

import org.springframework.data.repository.query.Param;
import spring.intro.entities.Book;
import spring.intro.entities.enums.AgeRestriction;
import spring.intro.entities.enums.Edition;

import java.util.Date;
import java.util.List;

public interface BookService {
    void seed() throws Exception;

    void save(Book book);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getTitlesByEditionsAndLessThanCopies(Edition edition, int copies);

    long increaseCopiesByDate(Date date, int additionalCopies);

    int deleteAllByCopiesLessThan(int copies);
}