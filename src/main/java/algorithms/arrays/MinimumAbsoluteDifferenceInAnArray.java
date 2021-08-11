package algorithms.arrays;

import java.util.Arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:45 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 */

public class MinimumAbsoluteDifferenceInAnArray {

    //CHUNGO, NO ES OPTIMO
    static int minimumAbsoluteDifferenceA(int[] arr) {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int absDifference = Math.abs(arr[i] - arr[j]);
                if(min > absDifference) {
                    min = absDifference;
                }
            }
        }
        return min;
    }

    //TAMBIEN CHUNGO POR EL TIPO DE SORTING
    static int minimumAbsoluteDifferenceB(int[] arr) {
        bubbleSort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int absDifference = Math.abs(arr[i] - arr[i + 1]);
            if(absDifference < min) {
                min = absDifference;
            }
        }
        return min;
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            int lastUnsorted = arr.length - 1;
            for(int i = 0; i < lastUnsorted; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    static int minimumAbsoluteDifferenceC(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int absDifference = Math.abs(arr[i] - arr[i + 1]);
            if(absDifference < min) {
                min = absDifference;
            }
        }
        return min;
    }




    public static void main(String[] args) {
        int[] array = {1, -3, 71, 68, 17};

        System.out.println(minimumAbsoluteDifferenceA(array));
        System.out.println(minimumAbsoluteDifferenceB(array));
        System.out.println(minimumAbsoluteDifferenceC(array));
    }
}
