package ru.itpark.implementation;

import ru.itpark.framework.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public String showText(String text) {
        return text;
    }
}
