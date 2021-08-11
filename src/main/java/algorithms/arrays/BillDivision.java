package algorithms.arrays;

import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:25 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/bon-appetit
 */

public class BillDivision {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int billTotal = 0;
        for(int dish : bill) {
            billTotal += dish;
        }

        if(b == (billTotal - bill.get(k))/2) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - (billTotal - bill.get(k))/2);
        }
    }

    @Test
    public void bonAppetitTest() {
        List<Integer> bill = List.of(3, 10, 2, 9);
        bonAppetit(bill, 1, 12);
    }
}
