package mainpack.controller.user;


import mainpack.entity.User;
import mainpack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "home";
    }


    @GetMapping("/addUser")
    public String add() {

        System.out.println(":)");

        return "redirect:users";
    }
}
