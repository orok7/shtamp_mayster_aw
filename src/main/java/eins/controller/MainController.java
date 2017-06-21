package eins.controller;

import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Controller
public class MainController {
    @Autowired
    private UserService uService;

    /*int pageNum = 1;
    int inPage = 10;
    int elemNum = 100;
    List<String> list;*/

    @ModelAttribute("loggedUser")
    public User post() {
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

    @GetMapping("/")
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
            int loggedUserId, @RequestParam(required = false) String logoutingModDisplay,
            Model model, HttpServletRequest r) {

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

        //makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/buildIndex")
    public String buildIndex() {

        return "index";
    }

//    private void makeContent(Model model, String uri){
//
//        if (list == null) {
//            list = new ArrayList<>();
//            for (int i = 1; i < elemNum + 1; i++)
//                list.add("Content " + i);
//        }
//
//        model.addAttribute("title", "Index page");
//        model.addAttribute("contentTitle", "Печатки для ФОП");
//        switch (uri){
//            case "/toFirstPage":
//                if (pageNum > 1) pageNum = 1;
//                break;
//            case "/prevPage":
//                if (pageNum > 1) pageNum--;
//                break;
//            case "/nextPage":
//                if (pageNum * inPage < list.size()) pageNum++;
//                break;
//            case "/toLastPage":
//                if (pageNum * inPage < list.size())
//                    pageNum = (int)Math.ceil((double)list.size() / inPage);
//                break;
//        }
//
//        boolean lastPage = inPage*pageNum >= list.size();
//
//        model.addAttribute("pageNum", pageNum);
//        model.addAttribute("lastPage", lastPage);
//
//        List<String> listOut = list.subList(
//                inPage*(pageNum-1),
//                (inPage*(pageNum-1)+inPage) > list.size()
//                        ?list.size():(inPage*(pageNum-1)+inPage));
//        model.addAttribute("list", listOut );
//    }
}