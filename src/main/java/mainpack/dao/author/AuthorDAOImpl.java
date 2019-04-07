package mainpack.dao.author;

import mainpack.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public List<Author> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query<Author> theQuery = session.createQuery("from Author",Author.class);

        return theQuery.getResultList();
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Author> theQuery = session.createQuery("from Author where id=:author_id",Author.class);
        Author tmp = theQuery.getSingleResult();

        if(tmp != null) {
            session.delete(tmp);
        }
        else{
            System.out.println("Nie znaleziono takiego autora");
        }
    }


    /*public void initAuthors() {

        Author author2 = new Author("Juliusz Slowacki","Pozytywizm");
        Author author3 = new Author("Ernest Hemingway","Nie wiem");

        this.add(author1);
        this.add(author2);
        this.add(author3);

    }*/
}
