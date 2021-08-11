package algorithms.arrays;


/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:02 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/countingsort1/problem
 */

public class CountSorting {

    static int[] countingSort(int[] arr) {
        int[] count = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }

        int[] first100 = new int[100];
        for(int i = 0; i < 100; i++) {
            first100[i] = count[i];
        }

        return first100;
//        return Arrays.copyOfRange(count, 0, 100);
    }

    public static void main(String[] args) {

    }
}
