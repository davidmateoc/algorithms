package algorithms.spotify;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 8/1/21
 * Time: 8:21 PM
 * Algorithm URL: https://leetcode.com/problems/roman-to-integer/
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = 0;
        int aPointer = 0;
        int bPointer = 1;

        while(bPointer < s.length()) {
            int valueAtAPointer = romanValues.get(s.charAt(aPointer));
            int valueAtBPointer = romanValues.get(s.charAt(bPointer));

            if(valueAtAPointer < valueAtBPointer) {
                total -= valueAtAPointer;
            } else {
                total += valueAtAPointer;
            }
            aPointer++;
            bPointer++;
        }
        return total + romanValues.get(s.charAt(s.length() - 1));
    }

    @Test
    public void RomanToIntegerTest() {
        Assert.assertThat(romanToInt("III"), Is.is(IsEqual.equalTo(3)));
        Assert.assertThat(romanToInt("IV"), Is.is(IsEqual.equalTo(4)));
        Assert.assertThat(romanToInt("IX"), Is.is(IsEqual.equalTo(9)));
        Assert.assertThat(romanToInt("LVIII"), Is.is(IsEqual.equalTo(58)));
        Assert.assertThat(romanToInt("MCMXCIV"), Is.is(IsEqual.equalTo(1994)));
    }
}

