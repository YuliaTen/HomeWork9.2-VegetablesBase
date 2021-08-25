package YuliaTench.HW9;



import YuliaTench.HW9.Food.*;
import YuliaTench.HW9.Stories.Store;
import YuliaTench.HW9.Stories.StoreDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GreenFoodBase {

    public void dostavka(List<Box<GreenFood>> baseStorage){
        //List<Box<GreenFood>> forStorage = new ArrayList<>();
        Random random = new Random();
        for(Box<GreenFood> box :baseStorage) {
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            randomStore.localStorage.add(box);
            GreenFood foodBox = box.food;
            ProverkaHashMap(foodBox,randomStore);

        }
    }

    private void ProverkaHashMap(GreenFood foodBox,Store store){
        for (Map.Entry<String, Double> entry : store.storageStatistics.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            String className = foodBox.getClass().getName();
            System.out.println(className);
            if (key.equals(className)) {
                Double value = entry.getValue();
                entry.setValue(value + foodBox.mass);
            } else
                store.storageStatistics.put(className, foodBox.mass);
        }
    }


    public List<Box<GreenFood>> initializeStartingSupplies(){
        List<Box<GreenFood>>  baseStorage= new ArrayList<>();

        generateGreenFoods().stream().map((g)->{
            Random random = new Random();
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            Box<GreenFood> box = new Box(randomStore.id, randomStore.brand, g);
            baseStorage.add(box);
            return baseStorage;
        });
        return baseStorage;
    }

    public List<GreenFood> generateGreenFoods(){
        List<GreenFood> generatedFood = new ArrayList<>();

        Random random = new Random();
        int greenFoodsCount = random.nextInt(30) + 30;

        for(int i=0; i<greenFoodsCount; i++) {
            int greenFoodChoice = random.nextInt(4);
            double price = random.nextDouble() * 30 + 10;
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
            generatedFood.add(greenFood);
        }

        return generatedFood;
    }
}
