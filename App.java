package YuliaTench.HW9;

import YuliaTench.HW9.Food.GreenFood;
import YuliaTench.HW9.Stories.Store;
import YuliaTench.HW9.Stories.StoreDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App
{
    public static void main( String[] args ){

        System.out.println("Генерируем магазины");
        StoreDatabase.generateStores();
        GreenFoodBase base = new GreenFoodBase();
        System.out.println("Генерируем еду и упаковываем по коробкам");
        List<Box<GreenFood>> listBox = base.initializeStartingSupplies();
        System.out.println("Пересылаем еду магазинам");
        base.dostavka(listBox);
        System.out.println("Создаем hashMap для каждого магазина");
        base.setHashMap();
        System.out.println("получаем рандомный магазин и сортируем у него товар по цене");
        Random random = new Random();
        Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
       // System.out.println("сортируем в выбранном магазине товар по цене");
        Store.sortPrice(randomStore);
        //System.out.println("сортируем в выбранном магазине товар по массе");
        Store.sortMass(randomStore);
        System.out.println("Получаем общую стоимоcть товаров");
        base.countAllFoodMoney(listBox);
        System.out.println("Получаем общую стоимоcть Фруктов дешевле 50р");
        base.countFruitMoneySmall50Rub(listBox);


    }
}
