package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 10:35 PM
 * Algorithm URL: https://www.codewars.com/kata/59590976838112bfea0000fa/train/java
 */

public class EnglishBeggar {

    public static int[] beggars(int[] values, int n) {
        int[] beggarCollect = new int[n];

        if(n == 0) {
            return beggarCollect;
        }

        for(int i = 0; i < values.length; i++) {
            beggarCollect[i % n] += values[i];
        }

        return beggarCollect;

    }

    public static void printArray(int[] arr) {
        for(int a : arr) {
            System.out.println(a);
        }
    }

    @Test
    public void EnglishBeggarTest() {
        int[] test = {1, 2, 3, 4, 5};
        printArray(beggars(test, 7));
    }
}

