package algorithms.integers;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/staircase
 */

public class Staircase {
    public static void staircase(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - 1 - i)).append("#".repeat(i + 1)).append("\n");
        }
        System.out.println(sb.toString());
    }

//    static void staircase(int n) {
//        for(int i = 1; i <= n; i++) {
//            String spaces = "";
//            String pounds = "";
//
//            for(int j = 0; j < n - i; j++) {
//                spaces += ' ';
//            }
//
//            for(int j = 0; j < i; j++) {
//                pounds += '#';
//            }
//            System.out.println(spaces + pounds);
//        }
//    }

    @Test
    public void staircaseTest() {
        staircase(4);
    }
}
