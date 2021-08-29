package YuliaTench.HW9.Food;

public class Apple extends Fruit {
    public Apple(double price, double mass) {
        super(price, mass);
    }

    @Override
    public String toString() {
        String name = getClass().getName();
        return  name+" Цена: " + price +", Масса: " + mass;
    }
}
