/*
package eins.controller;

import eins.entity.User;
import eins.service.interfaces.DbService;
import eins.service.interfaces.UserService;
import eins.service.utils.ClassUtil;
import eins.service.utils.SomeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController_Old {

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

//    @ModelAttribute("someEntity") public SomeClass someEntity() { return new SomeClass(); }

    @GetMapping("/saveSome{clazz}")
    public String saveSomeEntity(@PathVariable("clazz") String className,
                                 HttpServletRequest rq) throws Exception {

        className = packageName + "." + className;
        SomeClass someEntity = new SomeClass(className, dbService);
//        System.out.println(someEntity.getEntityClass());

        someEntity.setFields(someEntity.getFields()
                .stream()
                .map(o -> {
                    String[] pv = rq.getParameterValues(o.getFieldName());
                    String res = "";
                    if (pv!=null) {
                        if (pv.length > 1) for (String p : pv) res += p + "@&";
                        else res = pv[0];
                    } else res = null;
                    o.setFieldStringValue(res);
                    return o;
                })
        .collect(Collectors.toList()));

//        Map<String,String> map = someEntity.getFieldsMap();
//        System.out.println(map);
//
//        Mapable<?> mapable = (Mapable<?>) ClassUtil.newInstance(someEntity.getEntityClass());
//
//        Object o = mapable.parseFromMap(map, dbService);
//
//        System.out.println(o.getClass());
//        System.out.println(o);

        Object o = someEntity.getInstance(dbService);
        System.out.println(o);

        dbService.save(o,someEntity.getEntityClass());

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
//            model.addAttribute("someEntity", sc);
//            System.out.println(sc);
            model.addAttribute("entityFields", sc.getFields());
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

}*/
