package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:45 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/marcs-cakewalk/problem
 */

public class MarcsCakeWalk {


    static long marcsCakewalk(int[] calorie) {
        int[] sortedCalorieArray = reversedBubbleSort(calorie);
        long minMiles = 0;

        for(int i = 0; i < sortedCalorieArray.length; i++) {
            minMiles += (Math.pow(2, i) * sortedCalorieArray[i]);
        }
        return minMiles;
    }

    public static int[] reversedBubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        int numberOfSwaps = 0;

        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted; i++) {
                if(arr[i] < arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] caloriesA = {1, 2, 3};
        System.out.println(marcsCakewalk(caloriesA));

        int[] caloriesB = {7, 4, 9, 6};
        System.out.println(marcsCakewalk(caloriesB));
    }
}
