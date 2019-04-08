package mainpack.service.book;

import mainpack.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    void saveOrUpdate(Book book);
    void deleteById(int id);
    Book findById(int id);
    Book findByTitle(String title);
}
