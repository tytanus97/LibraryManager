package mainpack.controller;


import mainpack.entity.Book;
import mainpack.service.author.AuthorServiceTest;
import mainpack.service.book.BookService;
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


    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public String home(Model model) {

       List<Book> bookList = bookService.findAll();

       model.addAttribute("books",bookList);
        return "index";
    }


}
