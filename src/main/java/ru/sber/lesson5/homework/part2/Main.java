package ru.sber.lesson5.homework.part2;

import java.util.Optional;

//Написать свой аналог Optional
public class Main {
    public static void main(String[] args) {
        Optional<Integer> opt = Optional.of(1);
    }
}

final class MyOptional<T> {
    private static final MyOptional<?> EMPTY = new MyOptional<>();
    //private final T value;

    //Реализовать методы
    //private MyOptional(T value) {    }
    //of(T value) {
    //public T get() {
    //public boolean isPresent() {
    //public T orElse(T other) {
    //public  T orElseThrow()  {
}
