package algorithms.integers;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:46 PM
 * Algorithm URL: https://www.codewars.com/kata/5571f712ddf00b54420000ee
 */

public class LooseChange {

    public static HashMap<String, Integer> looseChange(int cent) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);

        if(cent <= 0) {
            return map;
        }

        // Pennies (1¢), Nickels (5¢), Dimes (10¢) and Quarters (25¢
        int quarters = cent / 25;
        int dimes = (cent - (25 * quarters)) / 10;
        int nickels = (cent - (10 * dimes) - (25 * quarters)) / 5;
        int pennies = (cent - (5 * nickels) - (10 * dimes) - (25 * quarters));

        map.put("Pennies", pennies);
        map.put("Nickels", nickels);
        map.put("Dimes", dimes);
        map.put("Quarters", quarters);

        return map;
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 4);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 1);
        LooseChange.looseChange(29);

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        LooseChange.looseChange(0);

        map = new HashMap<>();
        map.put("Pennies", 1);
        map.put("Nickels", 1);
        map.put("Dimes", 1);
        map.put("Quarters", 3);
        LooseChange.looseChange(91);

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        LooseChange.looseChange(-2);

    }
}
