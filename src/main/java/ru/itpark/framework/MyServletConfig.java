package ru.itpark.framework;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import ru.itpark.implementation.MyControllerImpl;
import ru.itpark.implementation.MyServiceImpl;

public class MyServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        //Создается Injector - класс, который отвечает за определение зависимостей по аннотации @Inject
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                //Маппинги сервлета, а также интерфейсов на их конкретные реализации
                serve("/").with(MyServlet.class);
                bind(MyService.class).to(MyServiceImpl.class);
                bind(MyController.class).to(MyControllerImpl.class);
            }
        });
    }
}
