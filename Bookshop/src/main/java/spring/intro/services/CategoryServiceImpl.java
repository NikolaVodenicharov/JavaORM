package spring.intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring.intro.common.FileManager;
import spring.intro.entities.Category;
import spring.intro.repositories.CategoryRepository;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService {
    private final String CATEGORIES_PATH = "C:\\Users\\WorkStation\\Desktop\\JavaORM\\Bookshop\\src\\main\\resources\\DummyDataInitializer\\categories.txt";
    private FileManager fileManager;

    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(FileManager fileManager, CategoryRepository repository){
        this.fileManager = fileManager;
        this.repository = repository;
    }

    public void seed() throws Exception {
        if (this.repository.count() > 0){
            return;
        }

        var lines = fileManager.readFile(CATEGORIES_PATH);

        for(var line : lines){
            var category = new Category();
            category.setName(line);

            this.save(category);
        }
    }

    @Override
    public void save(Category category) {
        this.repository.saveAndFlush(category);
    }
}
