package mainpack.controller;


import mainpack.crm.user.CrmUser;
import mainpack.entity.User;
import mainpack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("crmUser",new CrmUser());

        return "registrationForm";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@Valid @ModelAttribute("crmUser") CrmUser crmUser
                                    , BindingResult bindingResult,Model model) {


        String userName = crmUser.getUserName();
        String email = crmUser.getEmail();
        System.out.println("Processing registration for user: "+userName);
        if (bindingResult .hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            System.out.println("Something is wrong with binding result");
            return "registrationForm";
        }

        User existingUserName = userService.findByName(userName);
        User existingEmail = userService.findByEmail(email);


        if (existingUserName != null) {
            System.out.println("user exists");
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("userExistsError", "User already exist in database");

            return "registrationForm";
        }
        else if(existingEmail != null) {


            model.addAttribute("crmUser",new CrmUser());
            model.addAttribute("emailExistsError","Email address already in use");
            return "registrationForm";
        }

        userService.save(crmUser);
        System.out.println("user registered successfully");
        return "registrationConfirmation";
    }
}
