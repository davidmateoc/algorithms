package algorithms.arrays;

import java.util.Arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:03 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/mark-and-toys/problem
 */

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int totalSpent = 0;
        int toysBought = 0;

        for(int price : prices) {
            if(k >= totalSpent + price) {
                totalSpent += price;
                toysBought++;
            }
        }
        return toysBought;
    }

    public static void main(String[] args) {
        int[] prices = {45, 5};
        int budget = 50;

        System.out.println(maximumToys(prices, budget));
    }
}
