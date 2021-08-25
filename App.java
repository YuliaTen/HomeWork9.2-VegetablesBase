package YuliaTench.HW9;

import YuliaTench.HW9.Food.GreenFood;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        //System.out.println( "Hello World!" );
        GreenFoodBase greenBase = new GreenFoodBase();

        List<Box<GreenFood>> baseStorage =  greenBase.initializeStartingSupplies();
        greenBase.dostavka(baseStorage);

    }
}
