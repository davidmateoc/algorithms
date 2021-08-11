package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:25 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/between-two-sets
 */

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int total = 0;
        for(int i = a.get(a.size() - 1); i <= b.get(0); i++) {
            boolean isValid = true;
            for(int firstListElement : a) {
                if(i%firstListElement != 0) {
                    isValid = false;
                    break;
                }
            }

            for(int secondListElement : b) {
                if(secondListElement%i != 0) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                total++;
            }
        }
        return total;
    }

    @Test
    public void getTotalXTest() {
        List<Integer> a = List.of(2, 6);
        List<Integer> b = List.of(24, 36);
        Assert.assertThat(getTotalX(a, b), Is.is(IsEqual.equalTo(2)));
    }


}
