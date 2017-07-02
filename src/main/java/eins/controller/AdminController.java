package eins.controller;

import eins.entity.User;
import eins.service.interfaces.DbService;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/user/logout";
    }

    @GetMapping("/adminPage")
    public String adminPage(@CookieValue(value = "loggedUserId", defaultValue = "-1") int loggedUserId,
                            Model model){
        if (loggedUserId != -1) {
            User user = uService.findOne(loggedUserId);
            if (user.getLogin().equalsIgnoreCase("admin@admin")){
                return "adminPage";
            }
        }
        return "redirect:/init/index";
    }



    ////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////



    @Autowired
    private UserService uService;

    @Autowired
    private DbService dbService;

}