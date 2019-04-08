package mainpack.service.author;

import mainpack.entity.Author;

import java.util.List;

public interface AuthorServiceTest {

    void add(Author author);
    List<Author> findAll();
    void deleteById(int id);
    Author findByName(String name);

}
