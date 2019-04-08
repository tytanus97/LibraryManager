package mainpack.service.user;

import mainpack.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveOrUpdate(User user);
    void deleteById(int id);
    List<User> findAll();
    User findByName(String userName);


}
