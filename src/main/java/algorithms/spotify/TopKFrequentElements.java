package algorithms.spotify;

import org.junit.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Create by davidmateo
 * Date: 7/8/21
 * Time: 12:38 AM
 * Algorithm URL: https://leetcode.com/problems/top-k-frequent-elements/
 */

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numbers = new HashMap();

        for(int num : nums) {
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> numbers.get(n1) - numbers.get(n2));

        for(int key : numbers.keySet()) {
            queue.add(key);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] topKFrequent = new int[k];
        for(int i = 0; i < k; i++) {
            topKFrequent[i] = queue.poll();
        }

        return topKFrequent;
    }

    @Test
    public void TopKFrequentElementsTest() {
        int[] numsA = new int[]{1, 1, 1, 2, 2, 3};
        int[] numsB = new int[]{4,1,-1,2,-1,2,3};

//        topKFrequent(numsA, 2);
        topKFrequent(numsB, 2);
    }
}

