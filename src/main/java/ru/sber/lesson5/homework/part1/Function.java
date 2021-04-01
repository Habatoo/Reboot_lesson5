package ru.sber.lesson5.homework.part1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//Создать приватный конструктор
//Создать public static inner class Builder
//          В нем сделать сеттеры на каждое поле
//          сделать метод build()
//Создать метод public static FunctionBuilder builder() для получения билдера
//
public class Function {
    private UUID id;

    private String projectId;

    private String name;

    private String template;

    private String description;

    private List<String> endpoints;

    private Map<String, String> tags;

    private Map<String, String> environmentVariables;

    private String state;

    private LocalDateTime created;

    private LocalDateTime updated;
}
