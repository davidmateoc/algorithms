package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:55 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/migratory-birds
 */

public class MigratoryBirds {

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birds = new HashMap();
        for(int bird : arr) {
            if(birds.containsKey(bird)) {
                birds.put(bird, birds.get(bird) + 1);
            } else {
                birds.put(bird, 1);
            }
        }

        int maxAmountOfBirds = 0;
        int bird = 0;
        for(int birdType : birds.keySet()) {
            if(birds.get(birdType) > maxAmountOfBirds) {
                maxAmountOfBirds = birds.get(birdType);
                bird = birdType;
            }
        }
        return bird;
    }

    @Test
    public void migratoryBirdsTest() {
        List<Integer> birds = List.of(1, 4, 4, 4, 5, 3);
        Assert.assertThat(migratoryBirds(birds), Is.is(IsEqual.equalTo(4)));
    }
}
