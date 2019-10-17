package spring.intro.services;

import spring.intro.entities.Author;

public interface AuthorService {
    void seed() throws Exception;
    void save(Author author);
}
