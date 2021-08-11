package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:02 PM
 * Algorithm URL: https://leetcode.com/problems/sort-an-array/
 */

public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int izquierda, int derecha) {
        int pivote = array[izquierda];
        int i = izquierda;
        int j = derecha;

        while (i < j) {
            while (array[i] <= pivote && i < j)
                i++;
            while( array[j] > pivote){
                j--;
            }

            if(i < j) {
                int aux = array[j];
                array[j] = array[i];
                array[i] = aux;
            }
        }

        array[izquierda] = array[j];
        array[j] = pivote;

        if(izquierda < j - 1)
            quickSort(array, izquierda, j - 1);
        if(j + 1 < derecha) {
            quickSort(array, j + 1, derecha);
        }
    }

    public static void quickSortHackerRank(int[] array) {
        quickSortHackerRank(array, 0, array.length - 1);
    }
    public static void quickSortHackerRank(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSortHackerRank(array, left, index - 1);
        quickSortHackerRank(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while(left < right) {
            while(array[left] < array[pivot]) {
                left++;
            }

            while(array[right] > array[pivot]) {
                right--;
            }

            if(left < right) {
                int aux = array[left];
                array[left] = array[right];
                array[right] = aux;

                left++;
                right--;
            }
        }
        return left;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 4, 6, 9};
        quickSortHackerRank(arr);
        for(int value : arr) {
            System.out.println(value);
        }
    }
}
