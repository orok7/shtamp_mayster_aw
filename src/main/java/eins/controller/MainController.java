package eins.controller;

import eins.entity.User;
import eins.service.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "redirect:/init/index";
    }
}
