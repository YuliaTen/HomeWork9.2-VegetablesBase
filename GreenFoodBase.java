package YuliaTench.HW9;



import YuliaTench.HW9.Food.*;
import YuliaTench.HW9.Stories.Store;
import YuliaTench.HW9.Stories.StoreDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GreenFoodBase {

    static final Logger LOG = LogManager.getRootLogger();


    public void dostavka(List<Box<GreenFood>> baseStorage){
        Random random = new Random();
        int i = 0;
        for(Box<GreenFood> box :baseStorage) {
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            randomStore.localStorage.add(box);
            GreenFood foodBox = box.food;
            LOG.trace("Коробка: " + box.toString()+" отправлена в магазин " + randomStore);

        }
    }


    public  List<Box<GreenFood>> initializeStartingSupplies(){
        List<GreenFood> listFood = generateGreenFoods();
        List<Box<GreenFood>> boxes = new ArrayList<>();
        for(GreenFood food: listFood){
            Random random = new Random();
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            Box box = new Box(randomStore.id, randomStore.brand, food);
            LOG.trace("Сгенерирована коробка: " + box.toString());
           // System.out.println("Сгенерирована коробка: " + box.toString());
            boxes.add(box);
        }
        return boxes;
    }

    public List<GreenFood> generateGreenFoods(){
        List<GreenFood> generatedFood = new ArrayList<>();

        Random random = new Random();
        int greenFoodsCount = random.nextInt(40) + 30;
        LOG.info(String.format("Будет сгенерировано %d партий растительных продуктов.", greenFoodsCount));
        System.out.println(String.format("Будет сгенерировано %d партий растительных продуктов.", greenFoodsCount));

        for(int i=0; i<greenFoodsCount; i++) {
            int greenFoodChoice = random.nextInt(4);
            double price = random.nextDouble() * 50 + 10;
            double mass = random.nextDouble() * 5 + 20;

            GreenFood greenFood;
            switch (greenFoodChoice) {
                case 0:
                    greenFood = new Apple(price, mass);
                    break;
                case 1:
                    greenFood = new Banana(price, mass);
                    break;
                case 2:
                    greenFood = new Tomato(price, mass);
                    break;
                case 3:
                default:
                    greenFood = new Potato(price, mass);
                    break;
            }
            LOG.trace("Сгенерирована еда:"+greenFood.toString());
            System.out.println("Сгенерирована еда:"+greenFood.toString());
            generatedFood.add(greenFood);
        }

        return generatedFood;
    }

    public void countFruitMoneySmall50Rub(List<Box<GreenFood>> baseStorage){
        int countFruitMoney = baseStorage.stream()
                .filter(s->s.food.getClass().equals(Banana.class)||s.food.getClass().equals(Apple.class))
                .filter(s->s.food.price<50)
                .mapToInt(s -> (int) (s.food.price * s.food.mass)).sum();
        System.out.println("Сумма фруктов:" + countFruitMoney);
    }

    public void countAllFoodMoney(List<Box<GreenFood>> baseStorage){
        int countAllFoodMoney = baseStorage.stream().mapToInt(s -> (int) (s.food.price * s.food.mass)).sum();
        System.out.println("Сумма: "+ countAllFoodMoney);
    }

    public   void setHashMap(){
        for(Store store : StoreDatabase.allStores){
            int i=0;
            for (Box foodBox : store.localStorage){
                GreenFood food = (GreenFood)foodBox.getFood();
                String className = food.getClass().getName();
                System.out.println("еда "+className+" магазин: "+store.id);
                if (i==0) {store.storageStatistics.put(className, food.mass);i++;continue;}
                int k = 0;
                for (Map.Entry<String, Double> entry : store.storageStatistics.entrySet()) {
                    String key = entry.getKey();
                    if (key.equals(className)) {
                        k++;
                        Double value = entry.getValue();
                        store.storageStatistics.put(key,value + food.mass);
                        break;
                    }else if ((!(key.equals(className))) && (k < store.storageStatistics.size())) {k++;}
                     if ((!(key.equals(className))) && (k == store.storageStatistics.size())){
                        store.storageStatistics.put(className, food.mass);
                    }

                }
            }
        }

    }

}