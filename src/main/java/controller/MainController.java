package controller;

import commands.AccountCreateNew;
import exceptions.SMDBException;
import interfaces.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    int pageNum = 1;
    int inPage = 8;
    int elemNum = 100;
    List<String> list = new ArrayList<String>();
    {
        for (int i = 1; i < elemNum+1; i++)
            list.add("Content " + i);
    }

//    @Qualifier("r2")
//    private BlogDAO blogDAO;

    //    @RequestMapping(method = RequestMethod.GET, value = "/")
    @GetMapping("")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/registration")
    public String saveBlog(Model model){
//        makeContent(model);
//        Command cmd = new AccountCreateNew();
//        try {
//            cmd.execute(model);
//        } catch (SMDBException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    void makeContent(Model model){
//        model.addAttribute("title", "Index page");
//        model.addAttribute("contentTitle", "Печатки для ФОП");
//        switch (model..getRequestURI()){
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
//        request.setAttribute("pageNum", pageNum);
//        request.setAttribute("lastPage", lastPage);
//
//        List<String> listOut = list.subList(
//                inPage*(pageNum-1),
//                (inPage*(pageNum-1)+inPage) > list.size()
//                        ?list.size():(inPage*(pageNum-1)+inPage));
//        request.setAttribute("list", listOut );
    }
}