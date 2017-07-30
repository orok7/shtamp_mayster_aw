package eins.controller;

import eins.entity.User;
import eins.service.interfaces.DbService;
import eins.service.interfaces.MailService;
import eins.service.interfaces.UserService;
import eins.service.valid.UserLoginValidator;
import eins.service.valid.UserPassRecValidator;
import eins.service.valid.UserRegValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/regCompanyUser")
    public String regCompanyUser(@RequestParam String urCOwnership,
                                 @RequestParam String urCFullName,
                                 @RequestParam String urCShortName,
                                 @RequestParam String urCCode,
                                 @RequestParam String urCContactName,
                                 @RequestParam String urCContactSurname,
                                 @ModelAttribute("regUser") @Validated User user,
                                 BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("regModDisplay", "block");
            return "index";
        }

        /*uService.save(user.getLogin(), user.getPassword(), urCOwnership,
                urCFullName, urCShortName, urCCode,
                urCContactName, urCContactSurname);*/

        return "index";
    }



    @PostMapping("/regIndividualUser")
    public String regIndividualUser(@RequestParam String urIName,
                                    @RequestParam String urISurname,
                                    @ModelAttribute("regUser") @Validated User user,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("regModDisplay", "block");
            return "index";
        }

//        uService.save(user.getLogin(), user.getPassword(), urIName, urISurname);

        return "index";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute("loggedUser") @Validated User user,
                        BindingResult result, Model model, HttpServletResponse res) {
        if (result.hasErrors()) {
            model.addAttribute("loginingModDisplay", "block");
            return "index";
        }

        /*User fUser = uService.findByLogin(user.getLogin());
        Cookie cookie = new Cookie("loggedUserId", String.valueOf(fUser.getId()));
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        res.addCookie(cookie);*/

       /* if (fUser.getLogin().equalsIgnoreCase("admin@admin")) {
            return "redirect:/admin/adminPage";
        }*/

        return "index";
    }



    @PostMapping("/passrecovery")
    public String passrecovery(@ModelAttribute("passrecUser") @Validated User user,
                               BindingResult result, Model model) {

        //System.out.println(user);
//        user = (User) user;

        /*if (result.hasErrors()) {
            model.addAttribute("passRecModDisplay", "block");
            return "index";
        }
        User fUser = uService.findByLogin(user.getLogin());

        if (fUser != null) {
            if (!uService.userTempPassIsValid(fUser)) {
                uService.setTempPassword(fUser.getId(), generateTempPass());
                fUser = uService.findOne(fUser.getId());
                System.out.println(fUser);
                System.out.println(fUser.getCreateTempPassword());
            }
            double min = (System.currentTimeMillis() - fUser.getCreateTempPassword().getTime())/60000;
            mailService.sendMailRecPass(fUser.getLogin(),fUser.getTempPassword(), (5.0-min));
        }*/
        return "index";
    }



    @GetMapping("/logout")
    public String logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("loggedUserId", "-1");
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        res.addCookie(cookie);
        return "redirect:/init/index";
    }


    //////////////////////////////////////////////////////////////////////////



    @InitBinder("passrecUser")
    public void pruBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(uprValidator);
    }



    @InitBinder("regUser")
    public void ruBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(urValidator);
    }



    @InitBinder("loggedUser")
    public void luBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(ulValidator);
    }



    //////////////////////////////////////////////////////////////////////////////



    @Autowired
    private UserService uService;
    @Autowired
    private UserLoginValidator ulValidator;
    @Autowired
    private UserPassRecValidator uprValidator;
    @Autowired
    private UserRegValidator urValidator;
    @Autowired
    MailService mailService;



    private String generateTempPass(){
        String pass = "";
        Random r = new Random();
        List<Supplier<Integer>> funcs = new ArrayList<>();
        // number char code [48 - 57]
        funcs.add(() -> {return (r.nextInt(10)+48);});
        // bigger = 65 - 90
        funcs.add(() -> {return (r.nextInt(26)+65);});
        // smaller = 97 - 122
        funcs.add(() -> {return (r.nextInt(26)+97);});
        for (int i = 0; i < 6; i++){
            char ch = (char) (int) funcs.get(r.nextInt(3)).get();
            pass += ch;
        }
        return pass;
    }



    @ModelAttribute("loggedUser")
    public User loggedUser() {
        return new User();
    }



    @ModelAttribute("passrecUser")
    public User passrecUser() {
        return new User();
    }



    @ModelAttribute("regUser")
    public User regUser() {
        return new User();
    }
}