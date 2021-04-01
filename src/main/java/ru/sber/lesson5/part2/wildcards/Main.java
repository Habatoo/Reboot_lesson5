package ru.sber.lesson5.part2.wildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Вы используете ?, когда хотите указать, что любой тип вас устраивает. Чтобы указать хоть какой-то тип
public class Main {
    public static void printList(List<Object> list) {
        for (Object x : list)
            System.out.println(x);
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        //printList(keywords);  //- ошибка List<String> не подкласс List<Object>

        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(42));
        //Компилятор проверяет
        //List<Object> objects = numbers;
        //objects.add("forty two");
    }
}

class Main2 {
    public static void printList(List<?> list) {
        for (Object x : list)
            System.out.println(x);
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
    }
}

class UpperWildCard {
    public static void main(String[] args) {
        //ArrayList<Number> list = new ArrayList<Integer>(); // не компилируется
        List<? extends Number> list = new ArrayList<Integer>();
        List<Double> doubles = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        //total();
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

     /*public static long total(List list) { long count = 0;
        for (Object obj: list) {
            Number number = (Number) obj;
            count += number.longValue();
        }
        return count;
    }*/

    static class Sparrow extends Bird {
        void sing() {
            System.out.println("Sparrow");
        }
    }

    static class Bird {
        void sing() {
            System.out.println("bird");
        }
    }

    public static void main1(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
        //birds.add(new Sparrow());
        //birds.add(new Bird()); //мы не знаем какой именно класс лежит в списке
    }

    public static void sing(List<? extends Bird> list) {
        for (Bird b : list)
            b.sing();
    }

    <T> T first(List<? extends T> list) {
        return list.get(0);
    }

}

class LowerBoundWild {
    public static void main(String[] args) {
        List<? super IOException> exceptions = new ArrayList<Exception>(); //возможные значения List<IOException> or List<Exception> or List<Object>.
        //exceptions.add(new Exception()); // не компилируется, потому что у нас может быть List<IOException> и объект Exception туда не поместится.
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}


class HeapPoll {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(5);
        List<String> strings = (List) ints; //heap pollution raw type
        System.out.println(strings.get(0));
    }
}
//Collection<String> -> List<String> -> ArrayList<String>

