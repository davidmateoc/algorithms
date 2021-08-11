package algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:29 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/electronics-shop/problem
 */

public class ElectronicShop {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] keyboards = new Integer[n];
        for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] pendrives = new int[m];
        for (int pendrives_i = 0; pendrives_i < m; pendrives_i++) {
            pendrives[pendrives_i] = in.nextInt();
        }

        Arrays.sort(keyboards, Collections.reverseOrder());
        Arrays.sort(pendrives);
        int max = -1;

        for (int i = 0, j = 0; i < keyboards.length; i++) {
            for (; j < pendrives.length; j++) {
                if ((keyboards[i] + pendrives[j] > s)) {
                    break;
                }
                if ((keyboards[i] + pendrives[j]) > max) {
                    max = keyboards[i] + pendrives[j];
                }
            }
        }
        System.out.println(max);
    }
}
