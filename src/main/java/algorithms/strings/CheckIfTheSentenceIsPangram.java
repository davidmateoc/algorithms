package algorithms.strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 8:50 PM
 * Algorithm URL: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> mySet = new HashSet();

        for(char c : sentence.toCharArray()) {
            if(!mySet.contains(c)) {
                mySet.add(c);
            }
        }

        return mySet.size() == 26;
    }


    @Test
    public void CheckIfTheSentenceIsPangramTest() {
        checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
    }
}
