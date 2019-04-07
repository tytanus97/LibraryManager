package mainpack.controller;


import mainpack.entity.Author;
import mainpack.service.author.AuthorServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private AuthorServiceTest authorServiceTest;


    @GetMapping("/findAll")
    public String home(Model model) {

        List<Author> tmp = authorServiceTest.findAll();
        for (Author auth:tmp) {
            System.out.println(auth.toString());
        }
        model.addAttribute("duppa",tmp);
        return "home";
    }

    @GetMapping("/add")
    public String addSome() {
        Author author1 = new Author("Juliusz Slowacki","romantyzm");
        authorServiceTest.add(author1);

        return "redirect:findAll";
    }

    @GetMapping("/showLoginPage")
    public String getLoginForm(Model model) {
        return "loginPage";
    }
}
