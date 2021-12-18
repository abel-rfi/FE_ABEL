package id.co.lua.polua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; 

@Controller
public class DaftarPOController extends BasicController {
    @Autowired
    PasswordEncoder passwordEncoder;


    // viewing daftar-po page maybe
    @RequestMapping("/daftar-po")
    public ModelAndView main(ModelAndView mView,
                             @ModelAttribute(name = "result_code") String result_code,
                             @ModelAttribute(name = "result_message") String result_message,
                             RedirectAttributes redirectAttributes){
        System.out.println(passwordEncoder.encode("iuli123456"));
        mView.setViewName("pages/home/open-po/daftar-po");
        return mView;
    }
}
