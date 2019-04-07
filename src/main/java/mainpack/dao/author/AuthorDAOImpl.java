package mainpack.dao.author;

import mainpack.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{



    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public void add(Author author) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public List<Author> findAll() {
        session = sessionFactory.getCurrentSession();

        Query<Author> theQuery = session.createQuery("from Author",Author.class);

        return theQuery.getResultList();
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.getCurrentSession();
        Query<Author> theQuery = session.createQuery("from Author where id=:author_id",Author.class);

        Author tmp = findById(id);

        if(tmp != null) {
            session.delete(tmp);
        }
        else{
            System.out.println("Nie znaleziono takiego autora");
        }
    }

    public Author findById(int id) {
        session = sessionFactory.getCurrentSession();
        Query<Author> theQuery = session.createQuery("from Author where id=:author_id",Author.class);
        theQuery.setParameter("author_id",id);

        return theQuery.getSingleResult();
    }
}
