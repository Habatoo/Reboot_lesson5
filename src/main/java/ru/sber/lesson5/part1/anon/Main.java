package ru.sber.lesson5.part1.anon;

public class Main {
}

class Shop {
    abstract static class Sale {
        abstract int dollarsOff();
    }

    interface NewSale {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        Sale sale = new Sale() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };

        NewSale newSale = new NewSale() {
            @Override
            public int dollarsOff() {
                return 1;
            }
        };
        //можно сделать как локальным членом класса, так и переменной прокидывать в методы
        return basePrice - sale.dollarsOff() - newSale.dollarsOff();
    }
}
