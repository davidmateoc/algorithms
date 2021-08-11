package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:40 PM
 * Algorithm URL: Asked by DeepMind
 */

public class ShuffleArray {

    public static int[] shuffle(int[] arr, int[] positions) {
        int[] shuffledArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            shuffledArr[positions[i]] = arr[i];
        }

        return shuffledArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] position = {2, 1, 0, 3};


        int[] shuffledArr = shuffle(arr, position);

        for(int value : shuffledArr) {
            System.out.println(value);
        }
    }
}
