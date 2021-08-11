package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/diagonal-difference
 */

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int diagonalA = 0;
        int diagonalB = 0;

        for(int i = 0; i < arr.size(); i++) {
            diagonalA += arr.get(i).get(i);
            diagonalB += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(diagonalA - diagonalB);
    }

    @Test
    public void diagonalDifferenceTest() {
        List<List<Integer>> matrix = List.of(
            List.of(11, 2, 4),
            List.of(4, 5, 6),
            List.of(10, 8, -12)
        );

        Assert.assertThat(diagonalDifference(matrix), Is.is(IsEqual.equalTo(15)));
    }
}
