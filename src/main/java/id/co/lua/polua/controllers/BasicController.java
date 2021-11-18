package id.co.lua.polua.controllers;

import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.services.accounts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class BasicController {
    @Autowired
    UserService userService;

    public User userLogin;

    @ModelAttribute
    public void userLogin(Model model, Principal principal) {
        User user = null;
        if(principal != null) {
            user = userService.getByUsername(principal.getName());
            userLogin = user;
        }
        model.addAttribute("userLogin", user);
    }
}
