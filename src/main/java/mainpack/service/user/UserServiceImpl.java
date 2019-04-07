package mainpack.service.user;

import mainpack.dao.user.UserDAO;
import mainpack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void saveOrUpdate(User user) {
        userDAO.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> findAll() {


        return userDAO.findAll();
    }
}
