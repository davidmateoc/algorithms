package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:49 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */

public class JumpingOnClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;

        int pointerA = 0;
        int pointerB = 1;
        int pointerC = 2;

        while(pointerA < c.size() - 1) {
            if(pointerC < c.size() && c.get(pointerC) == 0) {
                pointerA = pointerC;
                pointerB = pointerC + 1;
                pointerC = pointerC + 2;
            } else {
                pointerA = pointerB;
                pointerC = pointerB + 2;
                pointerB = pointerB + 1;
            }
            jumps++;
        }
        return jumps;
    }

//    public int jumpingOnClouds(int[] c) {
//
//        int jumps = 0;
//        int cloudsBeforeThunder = 0;
//
//        for(int cloud : c) {
//            if(cloud == 0) {
//                cloudsBeforeThunder++;
//            } else {
//                jumps++;
//                jumps += cloudsBeforeThunder/2;
//                cloudsBeforeThunder = 0;
//            }
//        }
//        jumps += cloudsBeforeThunder/2;
//        return jumps;
//    }

    @Test
    public void jumpingOnCloudsTest() {
        List<Integer> clouds = List.of(0, 0, 0, 0, 1, 0);
        Assert.assertThat(jumpingOnClouds(clouds), Is.is(IsEqual.equalTo(3)));
    }
}
