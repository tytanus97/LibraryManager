package mainpack.controller;


import mainpack.entity.Author;
import mainpack.entity.User;
import mainpack.service.author.AuthorServiceTest;
import mainpack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private AuthorServiceTest authorServiceTest;

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String home(Model model) {

        List<Author> tmp = authorServiceTest.findAll();
        for (Author auth:tmp) {
            System.out.println(auth.toString());
        }
        model.addAttribute("duppa",tmp);

        List<User> userList = userService.findAll();

        model.addAttribute("users",userList);

        return "home";
    }

    @GetMapping("/add")
    public String addSome() {

        return "redirect:findAll";
    }

}
