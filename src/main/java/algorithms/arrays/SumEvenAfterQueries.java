package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:37 PM
 * Algorithm URL: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */

public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int resultOfSumQuery = sumEvenAfterQuery(A, query);

            res[i] = resultOfSumQuery;
        }
        return res;
    }

    public int sumEvenAfterQuery(int[] a, int[] query) {
        a[query[1]] += query[0];
        int countEven = 0;
        for(int val : a) {
            if(val % 2 == 0) {
                countEven += val;
            }
        }
        return countEven;
    }

    public int[] sumEvenAfterQueriesOptimal(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        int sum = 0;
        for(int val : A) {
            if(val % 2 == 0) {
                sum += val;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];

            if(A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += val;

            if(A[index] % 2 == 0) {
                sum += A[index];
            }
            res[i] = sum;
        }
        return res;
    }


    @Test
    public void sumEvenAfterQueriesTest() {
        assertThat(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}),
            is(equalTo(new int[]{8, 6, 2, 4})));
    }

    @Test
    public void sumEvenAfterQueriesOptimalTest() {
        assertThat(sumEvenAfterQueriesOptimal(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}),
            is(equalTo(new int[]{8, 6, 2, 4})));
    }
}
