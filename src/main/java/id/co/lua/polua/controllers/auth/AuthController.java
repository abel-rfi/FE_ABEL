package id.co.lua.polua.controllers.auth;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, ModelMap model,
                              @ModelAttribute(name = "result_code") String result_code,
                              @ModelAttribute(name = "result_message") String result_message,
                              RedirectAttributes redirectAttributes) {
        String error = (String) request.getSession().getAttribute("error");
        if (error != null) {
            model.addAttribute("error", error);
            request.getSession().removeAttribute("error");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/", model);
        }
        return new ModelAndView("auth/login", model);
    }
}
