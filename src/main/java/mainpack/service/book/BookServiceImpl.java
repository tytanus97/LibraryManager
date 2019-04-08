package mainpack.service.book;

import mainpack.dao.book.BookDAO;
import mainpack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    private BookDAO bookDAO;

    @Transactional
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Transactional
    @Override
    public void saveOrUpdate(Book book) {
        bookDAO.saveOrUpdate(book);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    @Transactional
    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Transactional
    @Override
    public Book findByTitle(String title) {

        return bookDAO.findByTitle(title);
    }
}
