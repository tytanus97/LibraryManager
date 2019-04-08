package mainpack.service.book;

import mainpack.dao.book.BookDAO;
import mainpack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookDAO.saveOrUpdate(book);
    }

    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }
}
