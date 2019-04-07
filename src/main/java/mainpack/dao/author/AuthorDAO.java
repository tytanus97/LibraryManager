package mainpack.dao.author;

import mainpack.entity.Author;

import java.util.List;

public interface AuthorDAO {

    void add(Author author);
    List<Author> findAll();
    void deleteById(int id);
}
