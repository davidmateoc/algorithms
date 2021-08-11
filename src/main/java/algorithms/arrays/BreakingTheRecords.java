package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:26 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/breaking-best-and-worst-records
 */

public class BreakingTheRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0);
        int max = scores.get(0);
        int numberOfTimesReachedMax = 0;
        int numberOfTimesReachedMin = 0;

        for(int score : scores) {
            if(score > max) {
                numberOfTimesReachedMax++;
                max = score;
            } else if (score < min){
                numberOfTimesReachedMin++;
                min = score;
            }
        }
        return List.of(numberOfTimesReachedMax, numberOfTimesReachedMin);
    }

    @Test
    public void breakingRecordsTest() {
        List<Integer> scores = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
        Assert.assertThat(breakingRecords(scores), Is.is(IsEqual.equalTo(List.of(4, 0))));
    }

}
