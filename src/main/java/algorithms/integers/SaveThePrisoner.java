package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/15/21
 * Time: 2:23 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/save-the-prisoner/problem
 */

public class SaveThePrisoner {

    public static int saveThePrisoner(int n, int m, int s) {
        int remainingTreats = m%n;
        return (remainingTreats + s - 1)%n == 0? n : (remainingTreats + s - 1)%n;
    }

    @Test
    public void SaveThePrisonerTest() {
        Assert.assertThat(saveThePrisoner(715950220, 876882456, 195550680), Is.is(IsEqual.equalTo(356482915)));
    }
}

