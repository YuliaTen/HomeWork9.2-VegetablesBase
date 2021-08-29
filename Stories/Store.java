package YuliaTench.HW9.Stories;


import YuliaTench.HW9.Box;
import YuliaTench.HW9.Food.GreenFood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Store {

    static final Logger LOG = LogManager.getRootLogger();

    public StoreBrand brand;
    public int id;
    public List<Box<GreenFood>> localStorage;
    public HashMap<String, Double> storageStatistics;



    public Store(StoreBrand brand) {
        this.brand = brand;
        this.id = (int)(Math.random() * 100000);
        this.localStorage = new ArrayList<>();
        this.storageStatistics = new HashMap<>();
        LOG.debug("Создан объект магазина с id = " + id);
    }



    public static  void  sortPrice(Store st) {
        ArrayList<GreenFood> foods = new ArrayList<>();
                for (Box<GreenFood> box : st.localStorage) {
                    GreenFood f = box.getFood();
                   // if (foods.size() == 0) {
                        foods.add(f);
                        continue;
//                    }
//                    int i = 0; int k = 0;
//                    for (GreenFood food : foods) {
//                        k++;
//                        if (!((f.getClass().getName()).equals(food.getClass().getName()))) {
//                            i++;
//                            if ((k == foods.size()) && (i == k)) {
//                                foods.add(f);
//                                break;
//                            }
//                        }
            }

        System.out.println("Ящиков еды в магазине - " + foods.size());
        System.out.println("Выводим еду в магазине");
        foods.stream().forEach(System.out::println);
        System.out.println("Выводим сортированную по увеличению цены еду в магазине");
        foods.stream()
                .sorted((o1, o2) -> (int) (o1.price - o2.price))
                .forEach(System.out::println);
    }

        public static  void  sortMass(Store st) {
            System.out.println("выводим список еды по массе для магазина "+ st.id);
            st.storageStatistics.entrySet().stream()
                    .forEach(System.out::println);
            System.out.println("сортируем еду по массе по убыванию");
            st.storageStatistics.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(System.out::println);
        }


}
