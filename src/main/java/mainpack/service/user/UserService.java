package mainpack.service.user;

import mainpack.crm.user.CrmUser;
import mainpack.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void deleteById(int id);
    List<User> findAll();
    User findByName(String userName);
    void save(CrmUser user);
    void save(User user);
    User findByEmail(String email);



}
