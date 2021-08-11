package algorithms.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 10:36 PM
 * Algorithm URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */

public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> allNums = new HashSet();
        List<Integer> duplicates = new ArrayList();

        for(int num : nums) {
            if(allNums.contains(num)) {
                duplicates.add(num);
            } else {
                allNums.add(num);
            }
        }

        return duplicates;
    }

    public List<Integer> findDuplicatesNoExtraSpace(int[] nums) {
        List<Integer> duplicates = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) duplicates.add(index + 1);
            nums[index] = -nums[index];

        }

        return duplicates;
    }

    @Test
    public void FindDuplicatesTest() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicatesNoExtraSpace(nums));
    }
}

