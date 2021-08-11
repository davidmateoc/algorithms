package algorithms.spotify;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/9/21
 * Time: 5:50 PM
 * Algorithm URL:
 */

public class RepeatedCharactersAndMaxValue {

    public String getStringWithMaxRepeatedCharacters(String word, int max) {
        if(word.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int aPointer = 0;
        int bPointer = 0;

        while(bPointer < word.length()) {
            if(word.charAt(bPointer) != word.charAt(aPointer)) {
                int numRepetitions = Math.min(max, bPointer - aPointer);
                sb.append((word.charAt(aPointer)+"").repeat(numRepetitions));
                aPointer = bPointer;
            }
            bPointer++;
        }
        int numRepetitions = Math.min(max, bPointer - aPointer);
        return sb.append((word.charAt(bPointer - 1)+"").repeat(numRepetitions)).toString();
    }

    @Test
    public void RepeatedCharactersAndMaxValueTest() {
        System.out.println(getStringWithMaxRepeatedCharacters("aaabaaa", 2));
    }
}

