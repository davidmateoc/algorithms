package algorithms.integers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:40 PM
 * Algorithm URL: https://leetcode.com/problems/distribute-candies-to-people/
 */

public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];

        for(int i = 0; candies > 0; i++) {
            people[i % num_people] =people[i % num_people] + Math.min((i + 1), candies);
            candies = candies - (i + 1);
        }

        return people;
    }

    public int[] distributeCandiesII(int candies, int num_people) {
        int[] people = new int[num_people];

        int i = 0;
        while(candies > 0) {
            if(candies > (i + 1)) {
                people[i % num_people] =people[i % num_people] + i + 1;
            } else {
                people[i % num_people] =people[i % num_people] + candies;
            }
            candies = candies - (i + 1);
            i++;
        }

        return people;
    }


    @Test
    public void distributeCandiesTest() {
        List<Integer> result = List.of(1, 2, 3, 1);
        assertThat(distributeCandies(7, 4), is(equalTo(result)));
    }
}
