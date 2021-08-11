package algorithms.spotify;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 3:54 AM
 * Algorithm URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;
        HashSet<Character> mySet = new HashSet<>();

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
    public void LongestSubstringWithoutRepeatingCharactersTest() {
        Assert.assertThat(lengthOfLongestSubstring("abcabcbb"), Is.is(IsEqual.equalTo(3)));
    }
}

