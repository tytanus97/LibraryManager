package mainpack.dao.user;

import mainpack.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDAO{

    void save(User user);
    void deleteById(int id);
    List<User> findAll();
    User findById(int id);
    User findByName(String userName);
}
