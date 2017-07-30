package eins.controller;

import eins.entity.User;
import eins.service.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "redirect:/main/index";
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        System.out.println("--- login");

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.addObject("loginingModDisplay", "block");
        model.setViewName("index");

        return model;

    }

    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginOk(){
        return "redirect:/admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(){
        return "redirect:/login?logout";
    }

    ////////////////////////////////////////////////////////////////////////////////////
}
