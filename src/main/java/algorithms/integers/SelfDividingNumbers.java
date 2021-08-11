package algorithms.integers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:50 PM
 * Algorithm URL: https://leetcode.com/problems/self-dividing-numbers/
 */

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDivNum = new ArrayList();

        while(left <= right) {
            String leftString = String.valueOf(left);
            boolean divisible = true;

            for(char c : leftString.toCharArray()) {
//                if(c == '0' || left % Integer.parseInt("" + c) != 0) {
                if(c == '0' || left % (c - '0') != 0) {
                    divisible = false;
                }
            }


            if(divisible) {
                selfDivNum.add(left);
            }

            left++;
        }

        return selfDivNum;
    }

    @Test
    public void selfDividingNumbersTest() {
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        assertThat(selfDividingNumbers(1, 22), is(equalTo(myList)));
    }
}
