package algorithms.arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:38 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/two-strings
 */

public class TwoStrings {

    static String twoStringsEfficient(String s1, String s2) {
        Set<Character> myLetters = new HashSet();
        for(int i = 0; i < s1.length(); i++) {
            if(!myLetters.contains(s1.charAt(i))) {
                myLetters.add(s1.charAt(i));
            }
        }

        for(int i = 0; i < s2.length(); i++) {
            if(myLetters.contains(s2.charAt(i))) {
                return "YES";
            }
        }
        return "NO";
    }

    static String twoStringsNotSoEfficient(String s1, String s2) {
        String output = "NO";

        for(int i = 0; i < s1.length(); i++) {
            if(s2.contains("" + s1.charAt(i))) {
                output = "YES";
                break;
            }
        }
        return output;
    }

    @Test
    public void twoStringsNotSoEfficientTest() {
        String a = "hello";
        String b = "hell";

        String result = twoStringsEfficient(a, b);
        String result2 = twoStringsNotSoEfficient(a, b);
        System.out.println(result);
        System.out.println(result2);
    }
}
