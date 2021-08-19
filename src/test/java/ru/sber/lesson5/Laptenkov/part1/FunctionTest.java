package ru.sber.lesson5.Laptenkov.part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    Function.Builder builder;
    LocalDateTime testDateTime = LocalDateTime.of(2021, 8, 12, 12, 12, 12);

    /**
     * Создаем объект класса {@link Function} с помощью билдера.
     */
    @BeforeEach
    void setUp() {
        builder = Function.builder();
    }

    /**
     * Проверка значения, которое возвращает метод {@link Function# Builder#build()}.
     * Сценарий, при котором {@link Function# Builder#build()} вызвывает не все
     * обязательные сеттеры для установки обязательных параметров.
     * <br>{@link Function# projectId} - id проекта,
     * <br>{@link Function# name} - наименование проекта,
     * <br>{@link Function# created} - дата содания (текущая дата).
     */
    @Test
    void builderFail() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> builder.setCreated().build());
        Assertions.assertEquals("Can't create valid Function object!", throwable.getMessage());
    }

    /**
     * Проверка значения, которое возвращает метод {@link Function# Builder#build()}
     * Сценарий, при котором {@link Function# Builder#build()} вызвывает сеттеры
     * для установки обязательных параметров
     * <br>{@link Function# projectId} - id проекта,
     * <br>{@link Function# name} - наименование проекта,
     * <br>{@link Function# created} - дата содания (текущая дата).
     */
    @Test
    void builderSuccess() {
        builder.setProjectId("PRJ")
                .setName("Test project")
                .setCreated(testDateTime)
                .build();
        Assertions.assertEquals("Function{id=null, projectId='PRJ', " +
                "name='Test project', template='null', description='null', " +
                "endpoints=null, tags=null, environmentVariables=null, state='null', " +
                "created=2021-08-12T12:12:12, updated=null}", builder.toString());
    }

}