package algorithms.integers;

import org.junit.Test;

import java.util.HashSet;

/**
 * Create by davidmateo
 * Date: 8/5/21
 * Time: 11:52 PM
 * Algorithm URL: https://leetcode.com/problems/happy-number/
 */

public class HappyNumbers {

    public boolean isHappy(int n) {
        HashSet<String> numbers = new HashSet<>();
        String number = String.valueOf(n);
        while(!number.equals("1") && !numbers.contains(number)) {
            numbers.add(number);
            int num = 0;
            for(int i = 0; i < number.length(); i++) {
                num += Math.pow(Character.getNumericValue(number.charAt(i)), 2);
            }
            number = String.valueOf(num);
        }
        return number.equals("1");
    }

    @Test
    public void HappyNumbersTest() {
        System.out.println(isHappy(19));
    }
}

