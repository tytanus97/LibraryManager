package mainpack.controller.user;


import mainpack.controller.TestController;
import mainpack.entity.Book;
import mainpack.entity.User;
import mainpack.service.book.BookService;
import mainpack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private TestController testController;

    @Autowired
    private BookService bookService;


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
    public String showUserDetails() {

        return "userDetail";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam("userName")String userName,@RequestParam("bookId")int bookId,Model model) {


        System.out.println(userName);
        boolean userContainsBook = false;
        //retrive user from data base by userName;
        User user = userService.findByName(userName);

        //retrive book from database by book id;

        Book book = bookService.findById(bookId);

        //add book to user book list
        for (Book userBook:user.getBookList()) {
            if(userBook.getId() == book.getId())
            {
                userContainsBook = true;
                break;
            }
        }

        if(!userContainsBook) {
            user.addBook(book);
            book.setAmount(book.getAmount()-1);

            userService.save(user);
            System.out.println("user updated");

            bookService.saveOrUpdate(book);
            System.out.println("book updated");
        }
        else {
            model.addAttribute("bookInBookList","You can't borrow this book twice");
        }
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books",bookList);

       return "index";

    }
}
