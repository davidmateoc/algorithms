package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:40 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = 0; i < q.length; i++) {
            if (q[i] -1 - i > 2) {
                System.out.println("Too chaotic");
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] q0 = {5, 2, 4, 1, 3};
        int[] q1 = {2, 1, 5, 3, 4};
        int[] q2 = {2, 5, 1, 3, 4};
        int[] q3 = {1, 2, 5, 3, 7, 8, 6, 4};

        minimumBribes(q0);
//        minimumBribes(q1);
//        minimumBribes(q2);
//        minimumBribes(q3);
    }
}
