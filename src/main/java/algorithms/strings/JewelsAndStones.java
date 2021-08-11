package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:23 PM
 * Algorithm URL: https://leetcode.com/problems/jewels-and-stones/
 */

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        int numberOfJewels = 0;
        for(char c : stones.toCharArray()){
            if(jewels.contains(String.valueOf(c)))
                numberOfJewels++;
        }
        return numberOfJewels;
    }

    @Test
    public void numJewelsInStonesTest() {
        assertThat(numJewelsInStones("aA", "aAAbbbb"), is(equalTo(3)));
    }
}
