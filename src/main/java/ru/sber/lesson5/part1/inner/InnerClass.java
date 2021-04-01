package ru.sber.lesson5.part1.inner;

public class InnerClass {
    /*
    Может быть объявлен как public, protected, по умолчанию или private.
    Может расширять любой не финальный класс и реализовывать интерфейсы
    Может быть абстрактным или final
    В нем невозможно объявить статические поля или методы, за исключением статических final полей
    Может получить доступ к членам внешнего класса, включая приватные члены
*/
}

class Outer {
    private String greeting = "Hi";

    private void print() {
        System.out.println("print");
    }

    protected class Inner {
        public int repeat = 3;
        //static int a = 0;
        //static void print(){}

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting); // может получить доступ к приватной переменной
            print();
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        //-----------------

        Inner inner = outer.new Inner(); // Так как не статический, то доступ можно получить только имея экземпляр внешнего
        inner.go();                      //Нам нужен экземпляр класса Outer, чтобы создать Inner.
        //Скомпилируется в  Outer$Inner.class.
    }
}

class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);// 30
                System.out.println(this.x); // 30
                System.out.println(B.this.x); // 20
                System.out.println(A.this.x); // 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}
