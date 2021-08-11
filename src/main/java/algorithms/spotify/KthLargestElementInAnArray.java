package algorithms.spotify;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Create by davidmateo
 * Date: 8/9/21
 * Time: 6:11 PM
 * Algorithm URL: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestOtherSolution(int[] nums, int k) {
        //initialize heap with the smallest element first
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int n : nums) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


    @Test
    public void KthLargestElementInAnArrayTest() {
        int sol = findKthLargestOtherSolution(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(sol);
    }
}

