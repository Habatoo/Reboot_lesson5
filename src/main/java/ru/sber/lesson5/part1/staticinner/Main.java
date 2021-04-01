package ru.sber.lesson5.part1.staticinner;

public class Main {
}

/*
Вложенность создает пространство имён.
Класс можно сделать public, protected, по умолчанию или private
Класс-обертка может ссылаться на поля и методы статического вложенного класса.
 */
class Enclosing {
    private int x = 1;
    static class Nested {
        private int price = 6;
    }

    private static class Nested2 {
        private int price = 6;
        public void print(Enclosing x){
            System.out.println(x.x);
        }

        public void print(){
            System.out.println("x"); // нельзя получить доступ
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        Nested2 nested1 = new Nested2();
        System.out.println(nested.price);
    }
}

