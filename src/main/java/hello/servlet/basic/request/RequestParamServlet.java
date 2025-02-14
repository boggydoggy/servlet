package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=kim&age=20&username=lee
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회(최초 값)] - start");
        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회(최초 값)] - end");

        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println();

        System.out.println("[복수 파라미터 조회]");
        String[] names = req.getParameterValues("username");
        for (String name : names) {
            System.out.println("username = " + name);
        }

        resp.getWriter().write("done");
    }
}
