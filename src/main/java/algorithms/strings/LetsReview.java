package algorithms.strings;

import org.junit.Test;

import java.util.Scanner;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:39 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/30-review-loop/problem
 */

public class LetsReview {

    static void splitEvenOdd(String s) {
        String even = "";
        String odd = "";

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even += s.charAt(i);
            } else {
                odd += s.charAt(i);
            }
        }
        System.out.println(even + " " + odd);
    }

    @Test
    public void SplitEvenOddTest() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < T; i++) {
            String s = scan.nextLine();
            splitEvenOdd(s);
        }
    }
}

