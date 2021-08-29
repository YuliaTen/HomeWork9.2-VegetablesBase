package YuliaTench.HW9.Stories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreDatabase {

    static final Logger LOG = LogManager.getRootLogger();

    public static List<Store> allStores;

    public static void generateStores() {
        LOG.info("Генерируем магазины.");
        allStores = new ArrayList<>();

        Random random = new Random();
        int storesCount = random.nextInt(5) + 5;
        for (int i = 0; i < storesCount; i++) {
            int storeBrandIndex = random.nextInt(StoreBrand.values().length);
            LOG.info("Генерируемый магазин будет принадлежать к сети " + StoreBrand.values()[storeBrandIndex]);
           // System.out.println("Генерируемый магазин будет принадлежать к сети " + StoreBrand.values()[storeBrandIndex]);
            allStores.add(new Store(StoreBrand.values()[storeBrandIndex]));
        }
    }
}