package mainpack.dao.book;

import mainpack.entity.Book;
import mainpack.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public List<Book> findAll() {
        session = sessionFactory.getCurrentSession();
        Query<Book> theQuery = session.createQuery("from Book",Book.class);
        return theQuery.getResultList();
    }


    @Override
    public void saveOrUpdate(Book book) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.getCurrentSession();
        Book tmpBook = findById(id);

        if(tmpBook!=null) {
            session.delete(tmpBook);
        }
    }

    @Override
    public Book findById(int id) {
        session = sessionFactory.getCurrentSession();
        System.out.println("Trying to execute query");
        Query<Book> theQuery = session.createQuery("from Book b left join fetch b.userList where b.id=:book_id ",Book.class);
        theQuery.setParameter("book_id",id);
        return theQuery.getSingleResult();
    }

    @Override
    public Book findByTitle(String title) {
        session = sessionFactory.getCurrentSession();
        Query<Book> theQuery = session.createQuery("from Book where title=:bookTitle",Book.class);
        theQuery.setParameter("bookTitle",title);
        return theQuery.getSingleResult();
    }
}
