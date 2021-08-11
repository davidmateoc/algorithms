package algorithms.integers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:48 PM
 * Algorithm URL: https://leetcode.com/problems/pascals-triangle-ii/
 */

public class PascalsTriangleII {

    public List<Integer> pascalsTriangleII(int numRows) {
        List<Integer> prevRow = List.of(1);

        if(numRows == 0) return prevRow;


        for(int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList();
            currentRow.add(1);

            for(int j = 1; j <= i ; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);
            prevRow = List.copyOf(currentRow);
            currentRow.clear();
        }

        return prevRow;

    }

    @Test
    public void pascalsTriangleTest() {
        List<Integer> result = List.of(1, 3, 3, 1);

        assertThat(pascalsTriangleII(3), is(equalTo(result)));
    }
}
