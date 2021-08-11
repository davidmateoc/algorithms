package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 10:31 PM
 * Algorithm URL:
 */

public class ReverseArray {

    public int[] reverseArray(int[] a) {
        int[] reversedArray = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            reversedArray[i] = a[a.length - 1 - i];
        }

        return reversedArray;

    }

    @Test
    public void ReverseArrayTest() {
        int[] array = {1, 4, 3, 2};

        Assert.assertThat(reverseArray(array), Is.is(IsEqual.equalTo(new int[]{2, 3, 4, 1})));
    }
}

