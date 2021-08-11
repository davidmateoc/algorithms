package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:42 PM
 * Algorithm URL: https://leetcode.com/problems/third-maximum-number/
 */

public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for(Integer num : nums) {
            if(num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax))
                continue;

            if(firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        if(thirdMax == null)
            thirdMax = firstMax;

        return thirdMax;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(thirdMax(nums));
    }
}
