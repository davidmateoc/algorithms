package algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:27 PM
 * Algorithm URL: https://leetcode.com/problems/contains-duplicate/
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet();
        for(int num : nums) {
            mySet.add(num);
        }

        return mySet.size() != nums.length;
    }

    @Test
    public void testContainsDuplicate() {
        Assert.assertTrue(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
