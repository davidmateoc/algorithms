package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://leetcode.com/problems/merge-intervals/
 */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> outputArr = new ArrayList();

        int[] currentInterval = intervals[0];
        outputArr.add(currentInterval);

        for(int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                outputArr.add(currentInterval);
            }
        }

        return outputArr.toArray(new int[outputArr.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedArray = merge(intervals);
    }
}
