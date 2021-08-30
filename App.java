package YuliaTench.HW9;

import YuliaTench.HW9.Food.GreenFood;
import YuliaTench.HW9.Stories.Store;
import YuliaTench.HW9.Stories.StoreDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App{

    static final Logger LOG = LogManager.getRootLogger();

    public static void main( String[] args ){

        StoreDatabase.generateStores();
        GreenFoodBase base = new GreenFoodBase();
        LOG.info("Генерируем еду и упаковываем по коробкам");
        List<Box<GreenFood>> listBox = base.initializeStartingSupplies();
        LOG.info("Пересылаем еду магазинам");
        base.dostavka(listBox);
        LOG.info("Создаем hashMap для каждого магазина");
        base.setHashMap();
        LOG.info("получаем рандомный магазин и сортируем у него товар по цене");
        Random random = new Random();
        Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
       // System.out.println("сортируем в выбранном магазине товар по цене");
        Store.sortPrice(randomStore);
        //System.out.println("сортируем в выбранном магазине товар по массе");
        Store.sortMass(randomStore);
        LOG.info("Получаем общую стоимоcть товаров");
        base.countAllFoodMoney(listBox);
        LOG.info("Получаем общую стоимоcть Фруктов дешевле 50р");
        base.countFruitMoneySmall50Rub(listBox);


    }
}
