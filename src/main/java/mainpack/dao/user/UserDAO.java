package mainpack.dao.user;

import mainpack.entity.User;

import java.util.List;

public interface UserDAO{

    void save(User user);
    void deleteById(int id);
    List<User> findAll();
    User findById(int id);
    User findByName(String userName);

}
