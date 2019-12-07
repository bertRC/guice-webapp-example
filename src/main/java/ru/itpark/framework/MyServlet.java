package ru.itpark.framework;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton  //Без этого не будет работать
public class MyServlet extends HttpServlet {
    private MyController controller;

    @Inject  //Можно инжектировать через конструктор, как это сделано в MyControllerImpl
    public void setController(MyController controller) {
        this.controller = controller;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Самая простая реализация без jsp-страничек
        req.setAttribute("text", controller.printMessage("Hello world!!!"));
        req.getRequestDispatcher("/WEB-INF/frontpage.jsp").forward(req, resp);
    }
}
