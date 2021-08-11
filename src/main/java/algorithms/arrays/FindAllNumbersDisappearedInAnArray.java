package algorithms.arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/6/21
 * Time: 2:32 AM
 * Algorithm URL: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

public class FindAllNumbersDisappearedInAnArray {


    //This solution is slow and times out with large inputs
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> myList = new LinkedList<>();
        List<Integer> dissapearedNumbers = new LinkedList<>();
        for(int i : nums) {
            myList.add(i);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!myList.contains(i)) {
                dissapearedNumbers.add(i);
            }
        }
        return dissapearedNumbers;
    }

    //Using hashset because its fast for checking if it contains and linkedlist because its fast adding elements
    public List<Integer> findDisappearedNumbersOptimized(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i : nums) {
            numbers.add(i);
        }

        List<Integer> result = new LinkedList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(!numbers.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void FindAllNumbersDisappearedInAnArrayTest() {
        findDisappearedNumbersOptimized(new int[]{4,3,2,7,8,2,3,1});
    }
}

