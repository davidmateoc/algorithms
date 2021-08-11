package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/13/21
 * Time: 10:44 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 */

public class BeautifulDaysAtMovies {

    public static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        for(int first = i; first <= j; first++) {
            if((first - reverse(first))%k == 0) {
                beautifulDays++;
            }
        }
        return beautifulDays;
    }

    public static int reverse(int day) {
        char[] dayArray = String.valueOf(day).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = dayArray.length - 1; i >= 0; i--) {
            sb.append(dayArray[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    @Test
    public void BeautifulDaysAtMoviesTest() {
        Assert.assertThat(beautifulDays(20, 23, 6), Is.is(IsEqual.equalTo(2)));
    }
}

