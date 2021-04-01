package ru.sber.lesson5.part2.wildcards;

import java.util.stream.Stream;

public class Inh {
    public static void main(String[] args) {
        Man<Dog> man1 = new Man<>();
        man1.bestFriend = new Dog();

        Man<Integer> integerMan = new Man<>();
        //Man3<Cat>
    }
}

interface Animal {
}

interface Good {
}

class Dog implements Animal {
}

class Cat implements Animal {
}

class Man<T> {
    T bestFriend;
}
class Man2<T extends Cat> {
    T bestFriend;
}

class Man3<T extends Animal & Good> {
    T bestFriend;
}
