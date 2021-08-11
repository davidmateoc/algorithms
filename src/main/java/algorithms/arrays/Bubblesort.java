package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:02 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 */

public class Bubblesort {

    public static int[] sort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;

        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return array;
    }

    public static int[] bubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        int numberOfSwaps = 0;

        while(!isSorted) {
            isSorted = true;
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
        return arr;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 3, 4};

        int[] sortedArray = Bubblesort.sort(array);
        for(int e : sortedArray) {
            System.out.println(e);
        }
        System.out.println("--------");
        int[] sortedArray2 = Bubblesort.bubbleSort(array);
        for(int e : sortedArray2) {
            System.out.println(e);
        }
    }
}
