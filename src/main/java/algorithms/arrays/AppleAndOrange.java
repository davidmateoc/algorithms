package algorithms.arrays;

import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:23 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/apple-and-orange/problem
 */

public class AppleAndOrange {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. s: integer, starting point of Sam's house location.
     *  2. t: integer, ending location of Sam's house location.
     *  3. a: integer, location of the Apple tree.
     *  4. b: integer, location of the Orange tree.
     *  5. apples: integer array, distances at which each apple falls from the tree.
     *  6. oranges: integer array, distances at which each orange falls from the tree.
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int applesInTheHouse = 0;
        int orangesInTheHouse = 0;

        for(int apple : apples) {
            if((apple + a) >= s && (apple + a) <= t) {
                applesInTheHouse++;
            }
        }

        for(int orange : oranges) {
            if((orange + b) >= s && (orange + b) <= t) {
                orangesInTheHouse++;
            }
        }

        System.out.println(applesInTheHouse);
        System.out.println(orangesInTheHouse);
    }

    @Test
    public void countApplesAndOrangesTest() {
        List<Integer> apples = List.of(2, 3, -4);
        List<Integer> oranges = List.of(3, -2, -4);
        countApplesAndOranges(7, 10, 4, 12, apples, oranges);
    }

}
