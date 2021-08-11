package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/15/21
 * Time: 2:04 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/strange-advertising/problem
 */

public class ViralAdvertising {

    public static int viralAdvertising(int n) {
        int cumulative = 2;
        int liked = 2;
        for(int i = 2; i <= n; i++) {
            liked = (liked * 3)/2;
            cumulative += liked;
        }
        return cumulative;
    }

    @Test
    public void ViralAdvertisingTest() {
        Assert.assertThat(viralAdvertising(3), Is.is(IsEqual.equalTo(9)));
        Assert.assertThat(viralAdvertising(4), Is.is(IsEqual.equalTo(15)));
    }
}

