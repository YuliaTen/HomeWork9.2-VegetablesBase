package YuliaTench.HW9.Food;

public class Banana extends Fruit{
    public Banana(double price, double mass) {
        super(price, mass);
    }

    @Override
    public String toString() {
        String name = getClass().getName();
        return  name+" Цена: " + price +", Масса: " + mass;
    }
}
