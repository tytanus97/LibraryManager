package mainpack.controller.user;


import mainpack.entity.Book;
import mainpack.entity.User;
import mainpack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String listAll(Model model) {
        List<User> userList = userService.findAll();

        model.addAttribute("users",userList);
        return "index";
    }

    @GetMapping("/addUser")
    public String add() {

        System.out.println(":)");

        return "redirect:users";
    }

    @PostMapping("/showUserDetails")
    public String showUserDetails(@RequestParam("userName")String userName,Model model) {
        System.out.println(userName);
        User user = userService.findByName(userName);
        List<Book> userBookList = user.getBookList();
        model.addAttribute("userBookList",userBookList);
        model.addAttribute("user",user);

        return "userDetail";
    }

    @PostMapping("/saveOrUpdate")
    public String showUserDetails(Model model) {

        return "userDetail";
    }
}
