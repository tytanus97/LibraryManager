package mainpack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginForm")
    public String getLoginForm() {
        return "loginPage";
    }


    @GetMapping("/accesDanied")
    public String accesDanied() {
        return "accesDaniedPage";
    }
}
