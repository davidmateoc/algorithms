package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/2d-array/problem
 */

public class TwoDimensionalArray {
    public static int hourglassSum(List<List<Integer>> arr) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int currentValue = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                    + arr.get(i + 1).get(j + 1)
                    + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                if (maxValue < currentValue) {
                    maxValue = currentValue;
                }
            }
        }


        return maxValue;

    }


    @Test
    public void hourglassSumTest() {
        List<List<Integer>> matrix = List.of(
            List.of(-9, -9, -9, 1, 1, 1),
            List.of(0, -9, 0, 4, 3, 2),
            List.of(-9, -9, -9, 1, 2, 3),
            List.of(0, 0, 8, 6, 6, 0),
            List.of(0, 0, 0, -2, 0, 0),
            List.of(0, 0, 1, 2, 4, 0));

        Assert.assertThat(hourglassSum(matrix), Is.is(IsEqual.equalTo(28)));
    }
}