package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:31 PM
 * Algorithm URL: https://leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = "";
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                str+= c;
        }

        System.out.println(str);
        str=str.toLowerCase();
        int aP = 0;
        int bP= str.length() - 1;

        while(aP < bP){
            if(str.charAt(aP) != str.charAt(bP))
                return false;
            aP++;
            bP--;
        }
        return true;
    }

    @Test
    public void validPalindromeTest() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
