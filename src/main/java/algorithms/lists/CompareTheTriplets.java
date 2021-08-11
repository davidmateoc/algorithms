package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/compare-the-triplets
 */

public class CompareTheTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alicePoints = 0;
        int bobPoints = 0;

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                alicePoints++;
            } else if(a.get(i) < b.get(i)) {
                bobPoints++;
            }
        }
        return List.of(alicePoints, bobPoints);
    }

    @Test
    public void compareTripletsTest() {
        List<Integer> a = List.of(5, 6, 7);
        List<Integer> b = List.of(3, 6, 10);
        Assert.assertEquals(compareTriplets(a, b), Is.is(IsEqual.equalTo(List.of(1, 1))));

    }
}
