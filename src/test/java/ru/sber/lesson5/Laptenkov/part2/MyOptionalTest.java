package ru.sber.lesson5.Laptenkov.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование методов класса {@link MyOptional}.
 * Тестирование проведено при параметрах {@link MyOptional}
 * - Integer
 * - String
 * - и кастомный объект типа TestObject
 *
 * @author habatoo
 */
public class MyOptionalTest {

    private MyOptional<Integer> myOptionalInteger;
    private MyOptional<String> myOptionalString;

    private class TestObject {
    }

    ;
    private MyOptional<TestObject> myOptionalTestObject;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Инициализация обьекта {@link MyOptional# myOptionalInteger} параметризованного Integer
     * Инициализация обьекта {@link MyOptional# myOptionalString} параметризованного String
     * Инициализация обьекта {@link MyOptional# myOptionalTestObject} параметризованного TestObject
     * Инициализация экземпляра класса {@link PrintStream} для контроля отображаемых сообщений.
     */
    @BeforeEach
    void setUp() {
        myOptionalInteger = MyOptional.of(10);
        myOptionalString = MyOptional.of("Test String");
        myOptionalTestObject = MyOptional.of(new TestObject());
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional# of(T)},
     * при подаче входящего параметра null.
     * <br>Сценарий, при котором {@link MyOptional# of(T)} выбрасывает {@link NullPointerException}
     * и сообщение "Value is null!".
     */
    @Test
    void ofNull_Test() {
        Throwable throwable = Assertions.assertThrows(NullPointerException.class, () -> MyOptional.of(null));
        Assertions.assertEquals("Value is null!", throwable.getMessage());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional# empty()}.
     * <br>Сценарий, при котором вызыватеся метод {@link MyOptional# empty()}
     * j,]trn {@link MyOptional} не должен быть равен null.
     */
    @Test
    void emptyNotNull_Tes() {
        Assertions.assertNotEquals(null, MyOptional.empty());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#get()},
     * на объекте {@link MyOptional} параметризованном {@link Integer}.
     * <br>Сценарий, при котором {@link MyOptional#get()} возвращает 10
     * если объект {@link MyOptional} инициирован 10.
     */
    @Test
    void getInteger_Test() {
        Assertions.assertEquals(10, myOptionalInteger.get());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#get()},
     * на объекте {@link MyOptional} параметризованном {@link String}.
     * <br>Сценарий, при котором {@link MyOptional#get()} возвращает "Test String"
     * если объект {@link MyOptional} инициирован "Test String".
     */
    @Test
    void getString_Test() {
        Assertions.assertEquals("Test String", myOptionalString.get());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#get()},
     * на объекте {@link MyOptional} параметризованном {@link TestObject}.
     * <br>Сценарий, при котором {@link MyOptional#get()} возвращенный объект
     * является объектом типа TestObject,
     * если объект {@link MyOptional} инициирован как TestObject.
     */
    @Test
    void getTestObject_Test() {
        Assertions.assertEquals(true, myOptionalTestObject.get() instanceof TestObject);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#isPresent()},
     * на объекте {@link MyOptional} параметризованном {@link Integer}.
     * <br>Сценарий, при котором {@link MyOptional#isPresent()} объект инициирован как Integer
     * возвращает <code>true</code>.
     */
    @Test
    void isPresentInteger_Test() {
        Assertions.assertEquals(true, myOptionalInteger.isPresent());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#isPresent()},
     * на объекте {@link MyOptional} параметризованном {@link String}.
     * <br>Сценарий, при котором {@link MyOptional#isPresent()} объект инициирован как String
     * возвращает <code>true</code>.
     */
    @Test
    void isPresentString_Test() {
        Assertions.assertEquals(true, myOptionalString.isPresent());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#isPresent()},
     * на объекте {@link MyOptional} параметризованном {@link TestObject}.
     * <br>Сценарий, при котором {@link MyOptional#isPresent()} объект инициирован как TestObject
     * возвращает <code>true</code>.
     */
    @Test
    void isPresentTestObject_Test() {
        Assertions.assertEquals(true, myOptionalTestObject.isPresent());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElse(Object)},
     * на объекте {@link MyOptional} параметризованном {@link Integer}.
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как 10
     * возвращает 10.
     */
    @Test
    void orElseInteger_Test() {
        Assertions.assertEquals(10, myOptionalInteger.orElse(50));
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElse(Object)},
     * на объекте {@link MyOptional} параметризованном {@link String}.
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как "Test String"
     * возвращает "Test String".
     */
    @Test
    void orElseString_Test() {
        Assertions.assertEquals("Test String", myOptionalString.orElse("Another String"));
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElse(Object)},
     * на объекте {@link MyOptional} параметризованном {@link TestObject}.
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как TestObject
     * возвращает TestObject.
     */
    @Test
    void orElseTestObject_Test() {
        Assertions.assertEquals(myOptionalTestObject.get(), myOptionalTestObject.orElse(new TestObject()));
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElse(Object)},
     * на объекте {@link MyOptional#empty()}
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как empty
     * Object (в тесте равен 1)..
     */
    @Test
    void orElseEmpty_Test() {
        Assertions.assertEquals(1, MyOptional.empty().orElse(1));
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElseThrow()},
     * на объекте {@link MyOptional#empty()}
     * <br>Сценарий, при котором {@link MyOptional#orElseThrow()} объект инициирован как empty
     * выбрасывает NoSuchElementException.
     */
    @Test
    void orElseThrowEmpty_Test() {
        Throwable throwable = Assertions.assertThrows(NoSuchElementException.class, () -> MyOptional.empty().orElseThrow());
        Assertions.assertEquals("No value present", throwable.getMessage());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElseThrow()},
     * на объекте {@link MyOptional} параметризованном {@link Integer}.
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как 10
     * возвращает 10.
     */
    @Test
    void orElseThrowInteger_Test() {
        Assertions.assertEquals(10, myOptionalInteger.orElseThrow());
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyOptional#orElseThrow()},
     * на объекте {@link MyOptional} параметризованном {@link String}.
     * <br>Сценарий, при котором {@link MyOptional#orElse(Object)} объект инициирован как Test String
     * возвращает Test String.
     */
    @Test
    void orElseThrowString_Test() {
        Assertions.assertEquals("Test String", myOptionalString.orElseThrow());
    }
}