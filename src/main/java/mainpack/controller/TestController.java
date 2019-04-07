package mainpack.controller;


import mainpack.entity.Author;
import mainpack.service.author.AuthorServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/author")
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
        Author author1 = new Author("Adam Mickiewicz","Romantyzm");
        authorServiceTest.add(author1);

        return "redirect:findAll";
    }
}
