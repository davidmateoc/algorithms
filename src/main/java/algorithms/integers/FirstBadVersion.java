package algorithms.integers;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:40 PM
 * Algorithm URL: https://leetcode.com/problems/first-bad-version/
 */

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while(left < right) {
            int midpoint = left + (right - left)/2;
            if(isBadVersion(midpoint)) {
                right = midpoint;
            } else {
                left = midpoint + 1;
            }
        }

        if(left == right && isBadVersion(right)) {
            return right;
        }

        return -1;
    }

    //This method is provided by LeetCode, so no need to worry about it.
    //Just adding to avoid compilation errors.
    public boolean isBadVersion(int version) {
        return true;
    }

    @Test
    public void firstBadVersionTest() {

    }
}
