package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:38 PM
 * Algorithm URL: https://leetcode.com/problems/rotate-array/
 */

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> rotArr = new ArrayList<>();
        for(int i = 0; i < a.size(); i++) {
            rotArr.add(a.get((d + i)%a.size()));
        }
        return rotArr;
    }

//    public int[] rotLeft(int[] a, int d) {
//        int[] aInverted = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            aInverted[i] = a[(i + d)%a.length];
//        }
//        return aInverted;
//    }

    @Test
    public void rotLeftTest() {
        List<Integer> a = List.of(1, 2, 3, 4, 5);
        int d = 4;
        Assert.assertThat(rotLeft(a, d), Is.is(IsEqual.equalTo(List.of(5, 1, 2, 3, 4))));
    }

}
