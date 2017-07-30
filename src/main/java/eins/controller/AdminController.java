/*
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

//    @GetMapping("/logout")
//    public String logout() {
//
//        return "redirect:/user/logout";
//    }

    @GetMapping("/adminPage")
    public String adminPage(){

        return "adminPage";
    }



    ////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////



    @Autowired
    private UserService uService;

    @Autowired
    private DbService dbService;

}*/
