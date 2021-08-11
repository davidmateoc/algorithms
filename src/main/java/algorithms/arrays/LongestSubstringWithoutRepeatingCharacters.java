package algorithms.arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:32 PM
 * Algorithm URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;
        Set<Character> mySet = new HashSet();

        while(bPointer < s.length()) {
            if(!mySet.contains(s.charAt(bPointer))) {
                mySet.add(s.charAt(bPointer));
                bPointer++;
                max = Math.max(max, mySet.size());
            } else {
                mySet.remove(s.charAt(aPointer));
                aPointer++;
            }
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assertThat(lengthOfLongestSubstring("dvdf"), is(equalTo(3)));
    }
}
