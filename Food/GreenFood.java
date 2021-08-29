package YuliaTench.HW9.Food;

public abstract class GreenFood {
    public double price;
    public double mass;

    public GreenFood(double price, double mass) {
        this.price = price;
        this.mass = mass;

    }



        @Override
        public String toString() {
        String name = getClass().getName();
          return  name+" Цена: " + price +", Масса: " + mass;
        }
}

