package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 12:44 PM
 * Algorithm URL: https://leetcode.com/problems/remove-vowels-from-a-string/
 */

public class RemoveVowelsFromAString {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(!"aeiou".contains("" + c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeVowelsII(String s) {
        return s.replaceAll("[aeiouAEIOU]", "");
    }

    @Test
    public void removeVowelsTest() {
        assertThat(removeVowels("leetcodeisacommunityforcoders"), is(equalTo("ltcdscmmntyfrcdrs")));
    }

    @Test
    public void removeVowelsTestII() {
        assertThat(removeVowelsII("leetcodeisacommunityforcoders"), is(equalTo("ltcdscmmntyfrcdrs")));
    }
}
