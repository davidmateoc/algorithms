package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:35 PM
 * Algorithm URL: https://leetcode.com/problems/sort-array-by-parity/
 */

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];

        int counter = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                res[counter] = A[i];
                counter++;
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 != 0) {
                res[counter ] = A[i];
                counter++;
            }
        }
        return res;
    }

    public int[] sortArrayByParityOptimal(int[] A) {
        int aPointer = 0;
        int bPointer = A.length - 1;

        while(aPointer < bPointer) {
            //If the value at aPointer is greater than the value at bPointer, when we swap because it means that
            //A[aPointer] % 2 is 1 and therefore its odd, whilst the other is 0 (even)
            if(A[aPointer] % 2 > A[bPointer] % 2) {
                int temp = A[aPointer];
                A[aPointer] = A[bPointer];
                A[bPointer] = temp;
            }
            if(A[aPointer] % 2 == 0) {
                aPointer++;
            }
            if(A[bPointer] % 2 != 0) {
                bPointer--;
            }
        }
        return A;
    }

    @Test
    public void sortArrayByParityTest() {
        assertThat(sortArrayByParity(new int[]{3, 1, 2, 4}), anyOf(
            is(equalTo(new int[]{4, 2, 3, 1})),
            is(equalTo(new int[]{2, 4, 1, 3})),
            is(equalTo(new int[]{2, 4, 3, 1})),
            is(equalTo(new int[]{4, 2, 1, 3}))
        ));
    }

    @Test
    public void sortArrayByParityOptimalTest() {
        assertThat(sortArrayByParityOptimal(new int[]{3, 1, 2, 4}), anyOf(
            is(equalTo(new int[]{4, 2, 3, 1})),
            is(equalTo(new int[]{2, 4, 1, 3})),
            is(equalTo(new int[]{2, 4, 3, 1})),
            is(equalTo(new int[]{4, 2, 1, 3}))
        ));

        assertThat(sortArrayByParityOptimal(new int[]{0, 1}), anyOf(
            is(equalTo(new int[]{0, 1}))
        ));
    }
}
