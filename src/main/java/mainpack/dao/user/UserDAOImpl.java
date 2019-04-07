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

    @Override
    public void saveOrUpdate(User user) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.getCurrentSession();
        Query<User> theQuery = session.createQuery("from User where id=:user_id",User.class);
        theQuery.setParameter("user_id",id);
        User tmp = theQuery.getSingleResult();

        if(tmp != null) {
            session.delete(tmp);
        }
    }

    @Override
    public List<User> findAll() {
        session = sessionFactory.getCurrentSession();
        Query<User> theQuery = session.createQuery("from User",User.class);

        return theQuery.getResultList();
    }
}
