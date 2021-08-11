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
 * Algorithm URL: https://leetcode.com/problems/pascals-triangle/
 */

public class PascalsTriangle {

    private List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList();

        if(numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList();
        firstRow.add(1);
        triangle.add(firstRow);

        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList();

            row.add(1);

            for(int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }


    @Test
    public void pascalsTriangleTest() {
        List<List<Integer>> result = List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1));

        assertThat(pascalsTriangle(5), is(equalTo(result)));
    }


}
