package eins.controller;

import eins.entity.User;
import eins.service.interfaces.MailService;
import eins.service.interfaces.UserService;
import eins.service.edit.UserLoginEditor;
import eins.service.valid.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;
    @Autowired
    private UserLoginValidator ulValidator;
    @Autowired
    private UserLoginEditor ulEditor;

    @ModelAttribute("loggedUser")
    public User post() {
        return new User();
    }

    @GetMapping("/logining")
    public String logining(Model model) {
        model.addAttribute("loginingModDisplay", "block");
        return "index";
    }

    @GetMapping("/logouting")
    public String logouting(Model model) {
        model.addAttribute("logoutingModDisplay", "block");
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loggedUser") @Validated User user,
                        BindingResult result, Model model, HttpServletResponse res) {
        if (result.hasErrors()) {
            model.addAttribute("loginingModDisplay", "block");
            return "index";
        }

        String userName = "";
        User fUser = uService.findByLogin(user.getLogin());
        Cookie cookie = new Cookie("loggedUserId", String.valueOf(fUser.getId()));
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        res.addCookie(cookie);
        System.out.println(String.valueOf(fUser.getId()));

        if (fUser.isCompany()) userName = fUser.getCompanyDate().getShortName();
        else userName = fUser.getIndividualDate().getName() + " " + fUser.getIndividualDate().getSurname();
        model.addAttribute("loggedUserName", userName);

        return "index";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletResponse res) {
        model.addAttribute("loggedUserName", "none");
        Cookie cookie = new Cookie("loggedUserId", "-1");
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        res.addCookie(cookie);
        return "index";
    }

    @InitBinder("loggedUser")
    public void luBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(ulValidator);
        webDataBinder.registerCustomEditor(User.class,ulEditor);
    }

    @Autowired
    MailService mailService;

    @GetMapping("/passrecovery")
    public String passrecovery() {
        mailService.sendMailRecPass("orestmykytyn@gmail.com","AXp4s5");
        return "index";
    }
}