package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:28 PM
 * Algorithm URL: https://leetcode.com/problems/reverse-only-letters/
 */

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] str = new char[S.length()];

        int aP = 0;
        int bP = S.length() - 1;

        while(aP <= bP) {
            if(!Character.isLetter(S.charAt(aP))){
                str[aP] = S.charAt(aP);
                aP++;
            }
            else if(!Character.isLetter(S.charAt(bP))){
                str[bP] = S.charAt(bP);
                bP--;
            }
            else {
                char temp = S.charAt(aP);
                str[aP] = S.charAt(bP);
                str[bP] = temp;
                aP++;
                bP--;
            }
        }
        return String.valueOf(str);
    }

    @Test
    public void reverseOnlyLettersTest() {
        assertThat(reverseOnlyLetters("Test1ng-Leet=code-Q!"), is(equalTo("Qedo1ct-eeLg=ntse-T!")));
    }
}
