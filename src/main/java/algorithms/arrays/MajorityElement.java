package algorithms.arrays;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 8/3/21
 * Time: 3:50 AM
 * Algorithm URL: https://leetcode.com/problems/majority-element/
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        for(int num : nums) {
            elements.put(num, elements.getOrDefault(num, 0) + 1);
        }

        int key = 0;
        int maxRepeated = 0;


        for(int elementKey : elements.keySet()) {
            if(elements.get(elementKey) > maxRepeated) {
                key = elementKey;
                maxRepeated = elements.get(elementKey);
            }
        }
        return key;
    }

    public int majorityElementOptimal(int[] nums) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        for(int num : nums) {
            elements.put(num, elements.getOrDefault(num, 0) + 1);
            if(elements.get(num) > nums.length/2) {
                return num;
            }
        }
        throw new IllegalArgumentException();
    }

    @Test
    public void MajorityElementTest() {

    }
}

