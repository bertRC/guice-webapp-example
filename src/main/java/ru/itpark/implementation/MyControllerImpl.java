package ru.itpark.implementation;

import com.google.inject.Inject;
import ru.itpark.framework.MyController;
import ru.itpark.framework.MyService;

public class MyControllerImpl implements MyController {
    private final MyService service;

    @Inject
    public MyControllerImpl(MyService service) {
        this.service = service;
    }

    @Override
    public String printMessage(String msg) {
        return "Message from my app: " + service.showText(msg);
    }
}
