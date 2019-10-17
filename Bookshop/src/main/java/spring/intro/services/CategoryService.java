package spring.intro.services;

import spring.intro.entities.Category;

public interface CategoryService {
    void seed() throws Exception;
    void save(Category category);
}
