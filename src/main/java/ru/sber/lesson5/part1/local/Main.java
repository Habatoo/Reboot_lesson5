package ru.sber.lesson5.part1.local;

public class Main {
}

class PrintNumbers {
    private int length = 5;

    public void calculate() {
        int width = 20; //effective final
        class MyLocalClass {
            public void multiply() {
                System.out.print(length * width);
            }
        }
        //width = 5;
        MyLocalClass local = new MyLocalClass();
        local.multiply();
    }

    public static void main(String[] args) {
        PrintNumbers outer = new PrintNumbers();
        outer.calculate();
    }
}
