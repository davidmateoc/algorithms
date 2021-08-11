package algorithms.integers;

import org.junit.Test;

import java.util.Scanner;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:45 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/30-binary-numbers/problem
 */

public class PrintMaximumConsecutiveOnesInBinaryBase {

    private static void printMaximumConsecutiveOnesInBinaryBase(int n) {
        String nString = Integer.toString(n, 2);
        int max = 0;
        String[] nArr = nString.split("0");
        for(String s: nArr) {
            if(s.length() > max) {
                max = s.length();
            }
        }
        System.out.println(max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    @Test
    public void PrintMaximumConsecutiveOnesInBinaryBaseTest() {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        printMaximumConsecutiveOnesInBinaryBase(n);
        scanner.close();
    }
}

