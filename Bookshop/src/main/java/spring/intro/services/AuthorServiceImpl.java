package spring.intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring.intro.common.FileManager;
import spring.intro.entities.Author;
import spring.intro.repositories.AuthorRepository;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {
    private final String AUTHORS_PATH = "C:\\Users\\WorkStation\\Desktop\\JavaORM\\Bookshop\\src\\main\\resources\\DummyDataInitializer\\authors.txt";
    private FileManager fileManager;

    private AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository, FileManager fileManager) {
        this.repository = repository;
        this.fileManager = fileManager;
    }

    public void seed() throws Exception {
        if (this.repository.count() > 0){
            return;
        }

        var lines = this.fileManager.readFile(AUTHORS_PATH);

        for (var line : lines) {
            var data = line.split("\\s+");
            var firstName = data[0];
            var lastName = data[1];

            var author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);

            this.save(author);
        }
    }

    @Override
    public void save(Author author) {
        repository.saveAndFlush(author);
    }
}
