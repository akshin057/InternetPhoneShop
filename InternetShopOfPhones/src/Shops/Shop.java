package Shops;

import Phones.Phone;

import java.io.File;
import java.io.FileNotFoundException;

public interface Shop {
    public static final int MAX_AMOUNT_OF_MODELS = 100;
    public void fillCatalog() throws FileNotFoundException;
    public void chooseModel();
    public int getSumOfAllSales();
    public void showStatistic();
    public void printCatalog();
    public Phone createPhone(String[] strings);
}
