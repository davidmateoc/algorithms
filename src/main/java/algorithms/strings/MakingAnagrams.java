package algorithms.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:08 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/making-anagrams
 */

public class MakingAnagrams {

    public static int makeAnagram(String a, String b) {
        int numLettersToRemove = a.length() + b.length();

        Map<Character, Integer> myLetters = new HashMap();
        for(int i = 0; i < a.length(); i++) {
            if(myLetters.containsKey(a.charAt(i))) {
                myLetters.put(a.charAt(i), myLetters.get(a.charAt(i)) + 1);
            } else {
                myLetters.put(a.charAt(i), 1);
            }
        }

        for(int i = 0; i < b.length(); i++) {
            if(myLetters.containsKey(b.charAt(i)) && myLetters.get(b.charAt(i)) > 0) {
                myLetters.put(b.charAt(i), myLetters.get(b.charAt(i)) - 1);
                numLettersToRemove -=2;
            }
        }
        return numLettersToRemove;
    }

    @Test
    public void makeAnagramTest() {

    }
}
