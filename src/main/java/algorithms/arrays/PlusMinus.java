package algorithms.arrays;

import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:55 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/plus-minus
 */

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        float positive = 0;
        float negative = 0;
        float zeros = 0;

        for(int value : arr) {
            if(value > 0) {
                positive++;
            } else if (value == 0) {
                zeros++;
            } else {
                negative++;
            }
        }
        System.out.println(positive/arr.size());
        System.out.println(negative/arr.size());
        System.out.println(zeros/arr.size());
    }

//    static void plusMinus(int[] arr) {
//        float denominator = arr.length;
//        float positive = 0;
//        float negative = 0;
//        float zeros = 0;
//        for(int i : arr) {
//            if (i > 0) {
//                positive++;
//            } else if (i < 0) {
//                negative++;
//            } else {
//                zeros++;
//            }
//        }
//        System.out.println(positive/denominator);
//        System.out.println(negative/denominator);
//        System.out.println(zeros/denominator);
//    }

    @Test
    public void plusMinusTest() {
        List<Integer> arr = List.of(-4, 3, -9, 0, 4, 1);
        plusMinus(arr);
    }
}
