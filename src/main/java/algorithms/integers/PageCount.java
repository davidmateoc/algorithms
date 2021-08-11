package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:42 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/drawing-book/problem
 */

public class PageCount {

    public static int pageCount(int n, int p) {
        int pageFromStart = p/2;
        int pagesFromBack = 0;

        if(n%2 != 0) {
            pagesFromBack = (n - p)/2;
        } else {
            if(p%2 == 0) {
                pagesFromBack = (n - p)/2;
            } else {
                pagesFromBack = 1 + ((n - p)/2);
            }
        }
        return Math.min(pageFromStart, pagesFromBack);
    }

    @Test
    public void pageCountTest() {
        Assert.assertThat(pageCount(5, 4), Is.is(IsEqual.equalTo(0)));
        Assert.assertThat(pageCount(6, 2), Is.is(IsEqual.equalTo(1)));
    }
}
