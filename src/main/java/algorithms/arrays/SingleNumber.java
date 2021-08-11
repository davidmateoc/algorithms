package algorithms.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:35 PM
 * Algorithm URL: https://leetcode.com/problems/single-number/
 */

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap();

        for(int num : nums) {
            if(myMap.containsKey(num)) {
                myMap.put(num, myMap.get(num) + 1);
            } else {
                myMap.put(num, 1);
            }
        }

        for(int key : myMap.keySet()) {
            if(myMap.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public int singleNumberOptimal(int[] nums) {
        int number = 0;
        for(int num : nums) {
            number ^= num;
        }
        return number;
    }

    @Test
    public void singleNumberTest() {
        assertThat(singleNumber(new int[]{2, 2, 1}), is(equalTo(1)));
    }

    @Test
    public void singleNumberOptimalTest() {
        assertThat(singleNumberOptimal(new int[]{2, 2, 1}), is(equalTo(1)));
    }
}
