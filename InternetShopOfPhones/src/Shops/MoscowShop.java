package Shops;

import Phones.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MoscowShop implements Shop {
    private Phone[] phones = new Phone[MAX_AMOUNT_OF_MODELS];
    private File file;
    private int countOfPhones;
    private int sumOfAllSales;

    public MoscowShop(String filename) throws FileNotFoundException {
        this.file = new File(filename);
        fillCatalog();
    }

    @Override
    public void fillCatalog() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int i = 0;
        while (true) {
            try {
                String line = scanner.nextLine();
                if (line == null) break;
                String[] strings = line.split(" ");
                phones[i++] = createPhone(strings);
            } catch (NoSuchElementException e) {
                countOfPhones = i;
                return;
            }
        }
        countOfPhones = i;
    }

    @Override
    public void chooseModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите смартфон");
        int phone = scanner.nextInt();
        System.out.println("Введите количество");
        int amount = scanner.nextInt();
        while (true){
            if (amount > phones[--phone].getAmount()){
                System.out.println("Такого количества в магазине нет");
                System.out.println("Попробуйте еще раз");
                amount = scanner.nextInt();
            }else {
                break;
            }
        }
        phones[phone].addSum(amount);
        phones[phone].setAmount(amount);
        sumOfAllSales+=(phones[phone].getPrice()*amount);
    }

    @Override
    public int getSumOfAllSales() {
        return sumOfAllSales;
    }

    @Override
    public void showStatistic(){
        for (int i = 0; i < countOfPhones; i++){
            int k = i + 1;
            System.out.println(k + ". " + phones[i]);
        }
    }

    @Override
    public void printCatalog() {
        for (int i = 0; i < countOfPhones; i++) {
            int k = i + 1;
            System.out.println(k + ". " + phones[i]);
        }
    }

    @Override
    public Phone createPhone(String[] strings) {
        int memory = Integer.parseInt(strings[2]);
        int price = Integer.parseInt(strings[4]);
        int amount = Integer.parseInt(strings[5]);
        switch (strings[0].charAt(0)) {
            case 'I' -> {
                return new Iphone(strings[0], strings[1], memory, price, amount);
            }
            case 'S' -> {
                return new Samsung(strings[0], strings[1], memory, price, amount);
            }
            case 'X' -> {
                return new Xiaomi(strings[0], strings[1], memory, price, amount);
            }
            case 'H' -> {
                return new Huawei(strings[0], strings[1], memory, price, amount);
            }
        }
        return new Phone("Телефон", "A", 256, 10000, 50);
    }


}
