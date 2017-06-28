package eins.controller;

import eins.entity.User;
import eins.service.interfaces.CompanyUserService;
import eins.service.interfaces.DbService;
import eins.service.interfaces.UserService;
import eins.service.utils.ClassUtil;
import eins.service.utils.EntityField;
import eins.service.utils.SomeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DbService dbService;

    @ModelAttribute("apEntitiesList")
    public List<String> apEntitiesList() {
        List<String> list = null;
        try {
            list = ClassUtil.getNames(packageName, classSuffix);
            list.add(0,"- Please select table -");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @ModelAttribute("someEntity") public SomeClass someEntity() { return new SomeClass(); }

    @GetMapping("/saveSome{clazz}")
    public String saveSomeEntity(@PathVariable("clazz") String className,
                                 @ModelAttribute("someEntity") Object someEntity,
                                    Model model) throws ClassNotFoundException {


        System.out.println(someEntity.getClass());
//        className = packageName + "." + className;
//        Class.forName(className).cast(someEntity);
//        System.out.println(someEntity);

        return "adminPage";
    }

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/user/logout";
    }

    @GetMapping("/buildForm")
    public String buildForm(@RequestParam String listEntities,
                            Model model) {

        if (listEntities.equalsIgnoreCase("- Please select table -")) {
            model.addAttribute("showBuildedForm", "false");
            return "redirect:/admin/adminPage";
        }

        String selectedClass = packageName + "." + listEntities + classSuffix;
        try {
            SomeClass sc = new SomeClass(selectedClass, dbService);
//            Object cast = sc.getEntityClass().cast(ClassUtil.newInstance(sc.getEntityClass()));
            model.addAttribute("someEntity", sc);
            System.out.println(sc);
            //model.addAttribute("entityFields", sc.getFields());
            model.addAttribute("entityName", sc.getEntityClass().getSimpleName());
            model.addAttribute("showBuildedForm", "true");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "adminPage";
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



//    @InitBinder("someEntity")
//    public void seBinder(WebDataBinder webDataBinder) {
//
//    }

    ////////////////////////////////////////////////////////////////////////


    private final String packageName = "eins.entity";
    private final String classSuffix = "";

    @Autowired
    private UserService uService;

}