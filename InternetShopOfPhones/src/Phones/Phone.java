package Phones;

public class Phone {
    private String brandName;
    private String model;
    private int memory;
    private int price;
    private int amount;
    private int sum;

    public Phone(String brandName, String model, int memory, int price, int amount) {
        this.brandName = brandName;
        this.model = model;
        this.memory = memory;
        this.price = price;
        this.amount = amount;
    }

    public void addSum(int amount){
        sum+=(amount*price);
    }

    public void setAmount(int amount){
        this.amount-=amount;
    }
    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return brandName + " " + model + ", цена = " + price + ", количество = " + amount + ", сумма продаж модели в магазине = " + sum;
    }
}
