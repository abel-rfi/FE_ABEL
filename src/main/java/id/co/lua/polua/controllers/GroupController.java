package id.co.lua.polua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import id.co.lua.polua.models.apps.Group;
import id.co.lua.polua.services.groups.GroupService;

// import javax.validation.Valid;
import java.util.List;

@Controller
public class GroupController extends BasicController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    GroupService groupService;


    @RequestMapping("/seller/group")
    public ModelAndView main(ModelAndView mView,
            @ModelAttribute(name = "result_code") String result_code,
            @ModelAttribute(name = "result_message") String result_message,
            RedirectAttributes redirectAttributes) {
        List<Group> groupList = groupService.getAll();
        mView.addObject("groupList", groupList);     
        mView.setViewName("pages/seller/group/group-index");
        return mView;
    }
}
