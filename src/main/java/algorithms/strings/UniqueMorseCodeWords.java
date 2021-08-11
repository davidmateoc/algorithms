package algorithms.strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:30 PM
 * Algorithm URL: https://leetcode.com/problems/unique-morse-code-words/
 */

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueMorseRepresentations = new HashSet();
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word : words) {
            String morseCodeWord = "";
            for(char c : word.toCharArray()) {
                morseCodeWord += morseCode[(int) c - 97];
            }
            uniqueMorseRepresentations.add(morseCodeWord);
        }
        return uniqueMorseRepresentations.size();
    }

    @Test
    public void uniqueMorseRepresentationsTest() {
        String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        assertThat(uniqueMorseRepresentations(words), is(equalTo(1)));
    }
}
