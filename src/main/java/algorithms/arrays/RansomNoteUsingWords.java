package algorithms.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class RansomNoteUsingWords {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        String output = "Yes";
        HashMap<String, Integer> myLetters = new HashMap();

        for(String word : magazine) {
            if(myLetters.containsKey(word)) {
                myLetters.put(word, myLetters.get(word) + 1);
            } else {
                myLetters.put(word, 1);
            }
        }

        for(String word : note) {
            if(myLetters.containsKey(word) && myLetters.get(word) > 0) {
                myLetters.put(word, myLetters.get(word) - 1);
            } else {
                output = "No";
                break;
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
