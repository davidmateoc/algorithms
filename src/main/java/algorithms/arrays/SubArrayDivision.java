package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:36 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/the-birthday-bar
 */

public class SubArrayDivision {

    public static int birthday(List<Integer> s, int d, int m) {
        int totalCombinations = 0;

        if(s.size() == 1 && m == 1 && d == s.get(0)) {
            return 1;
        }

        for(int i = 0; i <= s.size() - m; i++) {
            int sum = s.get(i);
            for(int j = i + 1; j < i + m; j++) {
                sum += s.get(j);
            }
            if(sum == d) {
                totalCombinations++;
            }
        }
        return totalCombinations;
    }

    @Test
    public void birthdayTest() {
        List<Integer> chocolates = List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1);
        Assert.assertThat(birthday(chocolates, 18, 7), Is.is(IsEqual.equalTo(3)));
    }
}
