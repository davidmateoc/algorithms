package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:44 PM
 * Algorithm URL: 
 */

public class Doubled {

    public static int[] makeDouble(int[] arr) {
        int[] arrDoubled = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            arrDoubled[i] = 2 * arr[i];
        }

        return  arrDoubled;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        makeDouble(arr);
    }
}
