package algorithms.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class RansomNoteUsingLetters {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        String output = "Yes";
        HashMap<Character, Integer> myLetters = new HashMap();

        for(String word : magazine) {
            for(int i = 0; i < word.length(); i++) {
                if(myLetters.containsKey(word.charAt(i))) {
                    myLetters.put(word.charAt(i), myLetters.get(word.charAt(i)) + 1);
                } else {
                    myLetters.put(word.charAt(i), 1);
                }
            }
        }

        for(String word : note) {
            for(int i = 0; i < word.length(); i++) {
                if(myLetters.containsKey(word.charAt(i)) && myLetters.get(word.charAt(i)) > 0) {
                    myLetters.put(word.charAt(i), myLetters.get(word.charAt(i)) - 1);
                } else {
                    output = "No";
                    break;
                }
            }
        }
        System.out.println(output);

    }

    @Test
    public void checkMagazineTest() {
        List<String> magazine = List.of("two", "times", "three", "is", "notw", "four");
        List<String> note = List.of("two", "times", "two", "is", "four");

        checkMagazine(magazine, note);
    }
}
