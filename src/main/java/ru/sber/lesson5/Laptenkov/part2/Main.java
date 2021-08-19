package ru.sber.lesson5.Laptenkov.part2;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> opt = Optional.of(1);
    }
}

/**
 * Реализация класса MyOptional, аналог {@link Optional}.
 * Параметризуется.
 *
 * @param <T>
 */
final class MyOptional<T> {
    /**
     * Пустой объект {@link MyOptional# EMPTY} класса {@link MyOptional}.
     */
    private static final MyOptional<?> EMPTY = new MyOptional<>();
    private final T value;

    /**
     * Конструктор для случаев не пустого значения {@link MyOptional#value}.
     *
     * @param value
     */
    private MyOptional(T value) {
        if (value == null) {
            throw new NullPointerException("Value is null!");
        } else {
            this.value = value;
        }
    }

    /**
     * Пустой конструктор для случаев пустого значения {@link MyOptional#value},
     * инициирует {@link MyOptional#value} значением null.
     */
    private MyOptional() {
        this.value = null;
    }

    /**
     * Метод {@link MyOptional#of} по переданному параметру
     * возвращает созданный объект {@link MyOptional}
     *
     * @param value объект типа T
     * @return возвращает new {@link MyOptional}
     */
    public static <T> MyOptional of(T value) {
        return new MyOptional<>(value);
    }

    /**
     * Метод {@link MyOptional#empty} взвращает пустой объект
     * {@link MyOptional#EMPTY} класса {@link MyOptional}.
     *
     * @return myOptional объект {@link MyOptional}.
     */
    public static <T> MyOptional<T> empty() {
        MyOptional<T> myOptional = (MyOptional<T>) EMPTY;
        return myOptional;
    }

    /**
     * Метод {@link MyOptional#get} возвращает {@link MyOptional#value}
     * в случае если его значение не null.
     * В случае пустого значения {@link MyOptional#value}
     * выбрасывает исключение NoSuchElementException.
     *
     * @return value
     */
    public T get() {
        if (null == value) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * Метод {@link MyOptional#isPresent} проверяет {@link MyOptional#value}
     * на равенство null.
     *
     * @return <code>true</code> если {@link MyOptional#value} не null,
     * иначе возвращает <code>false</code>.
     */
    public boolean isPresent() {
        if (null != value) {
            return true;
        }
        return false;
    }

    /**
     * Метод {@link MyOptional#orElse} проверяет значение {@link MyOptional#value}
     * на равенство null. В случае пустого значения возвращает значение по умолчанию
     *
     * @param {@link MyOptional#other} параметр метода типа T.
     * @return возвращает {@link MyOptional#value} в случае если его значение не null,
     * либо переданное в качестве параметра значение  {@link MyOptional# other}
     */
    public T orElse(T other) {
        if (null == value) {
            return other;
        }
        return value;
    }

    /**
     * Метод {@link MyOptional#orElseThrow} возвращает {@link MyOptional#value}
     * в случае если его значение не null.
     * В случае пустого значения {@link MyOptional#value}
     * выбрасывает исключение NoSuchElementException.
     *
     * @return value
     */
    public T orElseThrow() {
        if (null == value) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }
}