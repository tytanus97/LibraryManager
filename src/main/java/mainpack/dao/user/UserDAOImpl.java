package mainpack.dao.user;

import mainpack.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;


    public void save(User user) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.getCurrentSession();

        User tmp = findById(id);

        if(tmp != null) {
            session.delete(tmp);
        }
    }

    @Override
    public List<User> findAll() {
        session = sessionFactory.getCurrentSession();
        Query<User> theQuery = session.createQuery("select distinct a from User a join fetch a.roles",User.class);

        return theQuery.getResultList();
    }

    @Override
    public User findById(int id) {
        session = sessionFactory.getCurrentSession();
        Query<User> theQuery = session.createQuery("select distinct u from User u left join fetch u.bookList where u.id=:user_id",User.class);
        theQuery.setParameter("user_id",id);
        return theQuery.getSingleResult();
    }

    @Override
    public User findByName(String userName) {
        session = sessionFactory.getCurrentSession();
        Query<User> theQuery = session.createQuery("select distinct u from User u left join fetch u.bookList where u.username=:userName",User.class);
        theQuery.setParameter("userName",userName);
        try {
            return theQuery.getSingleResult();
        }
        catch(Exception exc) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        session = sessionFactory.getCurrentSession();

        Query<User> theQuery = session.createQuery("from User where email=:emailaddress",User.class);
        theQuery.setParameter("emailaddress",email);
        try {
            return theQuery.getSingleResult();
        }catch(Exception exc) {
            return null;
        }
    }

}
