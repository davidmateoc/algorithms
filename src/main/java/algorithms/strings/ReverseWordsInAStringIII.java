package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/6/21
 * Time: 3:24 AM
 * Algorithm URL: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word : words) {
            sb.append(reverse(word));
            sb.append(" ");

        }
        return sb.toString().trim();
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    @Test
    public void ReverseWordsInAStringIIITest() {
        String actualWord = "Let's take LeetCode contest";
        String expectedWord = "s'teL ekat edoCteeL tsetnoc";
        Assert.assertThat(reverseWords(actualWord), Is.is(IsEqual.equalTo(expectedWord)));
    }
}

