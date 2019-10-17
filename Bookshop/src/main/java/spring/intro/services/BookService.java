package spring.intro.services;

import spring.intro.entities.Book;

public interface BookService {
    void seed() throws Exception;
    void save(Book book);
}
