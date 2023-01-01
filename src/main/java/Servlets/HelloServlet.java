package Servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="WelcomeServlet", urlPatterns={"/WelcomeServlet"})
public class HelloServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();

    static class TempInnerClass {
        String key;
        String value;

        public TempInnerClass(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        String json = GSON.toJson(new TempInnerClass("JsonResp","Hello World !"));
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(json);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post method of Welcome Servlet");
    }
}
