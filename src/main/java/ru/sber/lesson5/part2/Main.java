package ru.sber.lesson5.part2;

public class Main {
    public static void main(String[] args) {
        Man<Dog> man1 = new Man<>();
        Man<Cat> man2 = new Man<>();
        man1.getBestFriend().sayGav();
        man2.getBestFriend().sayMeow();
        //man1.addBestFriend();
    }
}

class Man<T> {
    private T bestFriend;
    //static T bestFriend;

    public T getBestFriend() {
        return bestFriend;
    }

    public void addBestFriend(T bestFriend) {
        this.bestFriend = bestFriend;
    }
}

/*class Man {
    private Object bestFriend;

    public Object getBestFriend() {
        return bestFriend;
    }

    public void addBestFriend(Object bestFriend) {
        this.bestFriend = bestFriend;
    }
}*/

class Dog {
    void sayGav() {
        System.out.println("Gav");
    }
}

class Cat {
    void sayMeow() {
        System.out.println("Meow");
    }
}

class SuperMan<T, U> {
    private T friend;
    private U enemy;

    public SuperMan(T friend, U enemy) {
        this.friend = friend;
        this.enemy = enemy;
    }
}

