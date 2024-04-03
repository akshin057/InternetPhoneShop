package Shops;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VoronezhShop extends MoscowShop {
    File file1 = new File("VoronezhRepairCatalog");

    public VoronezhShop(String filename) throws FileNotFoundException {
        super(filename);
    }

    public void getPrice(String brandName, int choice) throws FileNotFoundException {
        Scanner scanner = new Scanner(file1);
        String price;
        String line;
        int count = 1;
        while (true) {
            try {
                line = scanner.nextLine();
                if (brandName.charAt(0) == line.charAt(0)) {
                    while (true){
                        price = scanner.nextLine();
                        if (choice == count) {
                            String[] strings = price.split(" ");
                            int priceInt = Integer.parseInt(strings[2]);
                            System.out.println("Ремонт будет стоить - " + priceInt + " рублей");
                            return;
                        }
                        count++;
                    }

                }
            } catch (NoSuchElementException e) {
                return;
            }
        }

    }
}
