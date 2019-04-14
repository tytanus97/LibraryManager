package mainpack.service.user;

import mainpack.crm.user.CrmUser;
import mainpack.dao.role.RoleDao;
import mainpack.dao.user.UserDAO;
import mainpack.entity.Role;
import mainpack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleDao roleDao;

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

    @Transactional
    @Override
    public User findByName(String userName) {
        return userDAO.findByName(userName);
    }

    @Transactional
    @Override
    public void save(User user) {

        userDAO.save(user);
    }

    @Transactional
    @Override
    public void save(CrmUser crmUser) {

        User user = new User();
        user.setUsername(crmUser.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(crmUser.getPassword()));
        user.setBookList(null);
        user.setEmail(crmUser.getEmail());
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

        userDAO.save(user);
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDAO.findByName(s);
        if(user==null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
