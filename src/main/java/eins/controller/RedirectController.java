package eins.controller;

import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/init")
public class RedirectController {

    @GetMapping("/index")
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
                        int loggedUserId, @RequestParam(required = false) String logoutingModDisplay,
                        Model model) {

        System.out.println(loggedUserId);
        logoutingModDisplay = (logoutingModDisplay==null)?"none":logoutingModDisplay;
        model.addAttribute("logoutingModDisplay", logoutingModDisplay);

        if (loggedUserId != -1) {
            String userName = "";
            User user = uService.findOne(loggedUserId);
            if (user.getIsCompany()) userName = user.getCompanyDate().getShortName();
            else userName = user.getIndividualDate().getName() + " " + user.getIndividualDate().getSurname();
            model.addAttribute("loggedUserName", userName);
        } else {
            System.out.println("Nobody logged");
        }

        return "index";
    }



    @GetMapping("/adminPage")
    public String adminPage(@CookieValue(value = "loggedUserId", defaultValue = "-1") int loggedUserId){
        if (loggedUserId != -1) {
            User user = uService.findOne(loggedUserId);
            if (user.getLogin().equalsIgnoreCase("admin@admin")){
                return "adminPage";
            }
        }
        return "redirect:/init/index";
    }

    ///////////////////////////////////////////////////////////////////



    @Autowired
    private UserService uService;
//    @Autowired
//    private UserLoginValidator ulValidator;
//    @Autowired
//    private UserPassRecValidator uprValidator;
//    @Autowired
//    private UserRegValidator urValidator;
//    @Autowired
//    MailService mailService;



    ///////////////////////////////////////////////////////////////////



    @ModelAttribute("loggedUser") public User loggedUser() { return new User(); }

    @ModelAttribute("passrecUser") public User passrecUser() { return new User(); }

    @ModelAttribute("regUser") public User regUser() { return new User(); }

}