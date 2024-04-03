import Phones.Iphone;
import Phones.Samsung;
import Shops.MoscowShop;
import Shops.VoronezhShop;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShopManager {
    String[] strings = {"Iphone", "Samsung", "Xiaomi", "Huawei"};
    MoscowShop moscowShop = new MoscowShop("MoscowCatalog");
    VoronezhShop voronezhShop = new VoronezhShop("VoronezhCatalog");

    public ShopManager() throws FileNotFoundException {
    }

    public void structure() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в наш интернет магазин!!!");
        System.out.println("Хотите продолжить?");
        System.out.println("1. Продолжить");
        System.out.println("2. Выйти");
        if (scanner.nextInt() == 2) {
            System.out.println("До свидания!!! Приходите еще!!!");
            return;
        }
        while (true) {
            chooseCity();
            System.out.println("Вы хотите выйти из интернет магазина?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            if (scanner.nextInt() == 1) {
                System.out.println("Спасибо за покупки!!! Приходите еще!!!");
                return;
            }
        }
    }

    public void chooseCity() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите город:");
        System.out.println("1. Москва");
        System.out.println("2. Воронеж");
        switch (scanner.nextInt()) {
            case 1 -> {
                while (true) {
                    moscowShop.printCatalog();
                    moscowShop.chooseModel();
                    System.out.println("Общая сумма продаж телефонов в данном филиале - " + moscowShop.getSumOfAllSales());
                    System.out.println("Хотите покинуть магазин в Москве?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    if (scanner.nextInt() == 1) {
                        break;
                    }
                }
                break;
            }
            case 2 -> {
                while (true) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Что вы хотите сделать?");
                    System.out.println("1. Купить телефон");
                    System.out.println("2. Отремонтировать телефон");
                    if (scanner1.nextInt() == 1) {
                        voronezhShop.printCatalog();
                        voronezhShop.chooseModel();
                        System.out.println("Общая сумма продаж телефонов в данном филиале - " + voronezhShop.getSumOfAllSales());
                    } else {
                        System.out.println("Какой смартфон вы хотите отремонтировать?");
                        int k = 1;
                        for (String element : strings) {
                            System.out.println(k + ". " + element);
                            k++;
                        }
                        int choice = scanner1.nextInt();

                        System.out.println("Что вы хотите отремонтировать?");
                        System.out.println("1. Экран");
                        System.out.println("2. Аккумулятор");
                        System.out.println("3. Динамики");
                        System.out.println("4. Зарядный порт");
                        System.out.println("5. Внутренности смартфона");
                        int choice1 = scanner.nextInt();

                        voronezhShop.getPrice(strings[--choice], choice1);

                    }
                    System.out.println("Хотите покинуть магазин в Воронеже?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    if (scanner.nextInt() == 1) {
                        break;
                    }
                }
                break;
            }
        }
    }

}
