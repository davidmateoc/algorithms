package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:29 PM
 * Algorithm URL: https://leetcode.com/problems/maximize-distance-to-closest-person/
 */

public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;

        while (bPointer < seats.length) {
            if (seats[bPointer] == 1) {
                if (aPointer == 0) {
                    max = Math.max(max, bPointer - aPointer);
                } else {
                    int distance = ((bPointer - aPointer) % 2 == 0) ? ((bPointer - aPointer) / 2) : ((bPointer - aPointer) / 2) + 1;
                    max = Math.max(max, distance);
                }
                aPointer = bPointer;
                aPointer++;
            }
            bPointer++;
        }
        return Math.max(max, bPointer - aPointer);
    }

    @Test
    public void MaximizeDistanceToClosestPersonTest() {

    }
}

