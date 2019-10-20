package spring.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.intro.entities.Book;
import spring.intro.entities.dto.BookSummaryDto;
import spring.intro.entities.enums.AgeRestriction;
import spring.intro.entities.enums.Edition;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionAndCopiesLessThan(Edition edition, int copies);

    @Query("select b.title " +
            "from Book as b " +
            "where b.edition = :edition and b.copies < :copies")
    List<String> getTitlesByEditionsAndLessThanCopies(
            @Param("edition")Edition edition,
            @Param("copies") int copies);

    List<Book> getAllByPriceLessThanOrPriceGreaterThan(BigDecimal lesserPrice, BigDecimal greaterPrice);

    List<Book> getAllByReleaseDateNot(Date date);

    List<Book> getAllByReleaseDateBefore(Date date);

    List<Book> getAllByTitleContains(String letters);

    @Query("select count(b) " +
            "from Book b " +
            "where length(b.title) > :length")
    int getCountByTitleLongerThan(@Param("length") int length);

    @Query("select new spring.intro.entities.dto.BookSummaryDto(b.title, b.edition, b.ageRestriction, b.price) " +
            "from Book as b " +
            "where b.title = :title")
    BookSummaryDto getBookSummaryByTitle(@Param("title") String title);

    @Modifying
    @Query("update " +
            "Book as b " +
            "set b.copies = b.copies + 100" +
            "where b.releaseDate > :date ")
    void increaseCopiesByDate(@Param("date") Date date);

    int countAllByReleaseDateAfter(Date date);

    int countAllByCopiesLessThan(int copies);

    void deleteAllByCopiesLessThan(int copies);
}
