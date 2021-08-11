package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:11 PM
 * Algorithm URL: 
 */

public class CountNumberOfCharacters {

    public static void printNumberOfCharacters(String sentence) {
        Map<Character, Integer> map = new HashMap();
        char[] charSentence = sentence.toCharArray();

        for(char c : charSentence) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("The sentence has the following characters:");
        for(char c : map.keySet()) {
            System.out.println(c + ": " + map.get(c));
        }
    }

    public static void main(String[] args) {
        String sentence = "hello how are you today?";
        printNumberOfCharacters(sentence);
    }
}
