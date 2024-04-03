package Phones;

public class Iphone extends Phone{
    public Iphone(String brandName, String model, int memory, int price, int amount) {
        super(brandName, model, memory, price, amount);
    }

    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    @Override
    public void addSum(int amount) {
        super.addSum(amount);
    }

    @Override
    public String getBrandName() {
        return super.getBrandName();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }

    @Override
    public int getSum() {
        return super.getSum();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
