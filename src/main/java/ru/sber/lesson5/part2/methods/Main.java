package ru.sber.lesson5.part2.methods;

public class Main {
    //Обычно можно вызвать общий метод, и компилятор попытается выяснить,
    // какой из них вам нужен. Или же вы можете явно указать тип, чтобы было ясно, что это за тип.
    public static void main(String[] args) {
        More.<String>identity("");
        More.identity("");

        Crate<String> crate = new Crate<>();
        crate.<Integer>tricky(1);
    }
}

class More {
    public static <T> void sink(T t) {
    }

    public static <T> T identity(T t) {
        return t;
    }
    //public static T noGood(T t) { return t; }
}

class Crate<T> {
    T item;
    //методы параметризуются отдельно
    public <T> T tricky(T t) {
        return t;
    }
}