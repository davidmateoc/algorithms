package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:01 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/icecream-parlor/problem
 */

public class IcecreamParlor {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        int[] pos = new int[2];
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(m == (arr[i] + arr[j])) {
                    pos[0] = i + 1;
                    pos[1] = j + 1;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int m = 4;
        int[] arr = {1, 4, 5, 3, 2};
        int[] solution = icecreamParlor(m, arr);
        for(int i : solution) {
            System.out.println(i);
        }
    }
}
