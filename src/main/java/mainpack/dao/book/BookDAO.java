package mainpack.dao.book;

import mainpack.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    void saveOrUpdate(Book book);
    void deleteById(int id);
    Book findById(int id);
    Book findByTitle(String title);
}
