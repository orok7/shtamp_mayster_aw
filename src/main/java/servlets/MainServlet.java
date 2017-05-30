package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    int pageNum = 3;
    int inPage = 8;
    int elemNum = 100;
    List<String> list = new ArrayList<String>();

    @Override
    public void init() throws ServletException {
        super.init();
        for (int i = 1; i < elemNum+1; i++)
            list.add("Content " + i);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getRequestURI());

        request.setAttribute("title", "Index page");
        request.setAttribute("contentTitle", "Печатки для ФОП");

        switch (request.getRequestURI()){
            case "/toFirstPage":
                if (pageNum > 1) pageNum = 1;
                break;
            case "/prevPage":
                if (pageNum > 1) pageNum--;
                break;
            case "/nextPage":
                if (pageNum * inPage < list.size()) pageNum++;
                break;
            case "/toLastPage":
                if (pageNum * inPage < list.size())
                    pageNum = (int)Math.ceil((double)list.size() / inPage);
                break;
        }

        boolean lastPage = inPage*pageNum >= list.size();

        request.setAttribute("pageNum", pageNum);
        request.setAttribute("lastPage", lastPage);

        List<String> listOut = list.subList(
                inPage*(pageNum-1),
                (inPage*(pageNum-1)+inPage) > list.size()
                        ?list.size():(inPage*(pageNum-1)+inPage));
        request.setAttribute("list", listOut );
        request
                .getRequestDispatcher("pages/index.jsp")
                .forward(request, response);
    }
}
