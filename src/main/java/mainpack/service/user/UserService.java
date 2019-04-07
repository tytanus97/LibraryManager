package mainpack.service.user;

import mainpack.entity.User;

import java.util.List;

public interface UserService {

    void saveOrUpdate(User user);
    void deleteById(int id);
    List<User> findAll();


}
