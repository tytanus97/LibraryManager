package mainpack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginForm")
    public String getLoginForm() {
        return "loginPage";
    }


    @GetMapping("/acces-danied")
    public String accesDanied() {
        return "loginPage";
    }


    @PostMapping("/authenticateTheUser")
    public String authenticateTheUser() {

        System.out.println("DUPA");
        return "index";
    }


    @GetMapping("/showLogoutPage")
    public String logoutPage() {

        return "loginPage";

    }

}
