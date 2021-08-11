package algorithms.spotify;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 8:12 PM
 * Algorithm URL: https://leetcode.com/problems/k-closest-points-to-origin/
 */

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] +a[1]*a[1]));
        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[k][2];
        while(k-- > 0) {
            result[k] = maxHeap.remove();
        }
        return result;
    }

    @Test
    public void KClosestPointsToOriginTest() {

    }
}

