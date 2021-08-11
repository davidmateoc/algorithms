package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:41 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/kangaroo/submissions
 */

public class Kangaroos {

//     *  1. INTEGER x1 Kangaroo 1 initial position
//     *  2. INTEGER v1 Kangaroo 1 jump width
//     *  3. INTEGER x2 Kangaroo 2 initial position
//     *  4. INTEGER v2 Kangaroo 2 jump width
    public static String kangaroo(int x1, int v1, int x2, int v2) {

        //x1 is always behind x2, so if the velocity is also lower then it will never catch up
        if(v1 > v2) {

            //With v1 - v2 you get how much distance one is gaining per jump
            //With x2 - x1 you get the initial distance
            //If the initial distance can be a total of the gainings per jump then they will meet
            if((x2 - x1)%(v1 - v2) == 0) {
                return "YES";
            }
        }
        return "NO";
    }

    @Test
    public void kangarooTest() {
        Assert.assertThat(kangaroo(0, 3, 4, 2), Is.is(IsEqual.equalTo("YES")));
        Assert.assertThat(kangaroo(0, 2, 5, 3), Is.is(IsEqual.equalTo("NO")));
        Assert.assertThat(kangaroo(28, 8, 96, 2), Is.is(IsEqual.equalTo("NO")));
        Assert.assertThat(kangaroo(4523, 8092, 9419, 8076), Is.is(IsEqual.equalTo("YES")));
    }
}
