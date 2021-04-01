package ru.sber.lesson5.part2.interfaces;

//Generic Interfaces
public class Main {
}

interface Shippable<T> {
    void ship(T t);
}

class ShippableRobotCrate implements Shippable<String> {

    @Override
    public void ship(String s) {

    }
}

class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) { } }

