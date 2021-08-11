package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:28 PM
 * Algorithm URL: 
 */

public class NumberOfVowels {


    public int getNumberOfVowels(String s) {
        int numberOfVowels = 0;
        String vowels = "aeiou";
        for(char c : s.toCharArray()) {
            if(vowels.contains(String.valueOf(c))) {
                numberOfVowels++;
            }
        }
        return numberOfVowels;
    }

    @Test
    public void numberOfVowelsTest() {
        assertThat(getNumberOfVowels("Hello"), is(equalTo(2)));
    }
}
