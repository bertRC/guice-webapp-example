package ru.itpark.framework;

import com.google.inject.Inject;
import com.google.inject.Singleton;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Самая простая реализация без jsp-страничек
        resp.getWriter().print(controller.printMessage("Hello world!!!"));
    }
}
