package algorithms.spotify;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 4:10 AM
 * Algorithm URL: https://leetcode.com/problems/ransom-note/
 */

public class RansomNode {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> myHashMap = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            if(myHashMap.containsKey(c)) {
                myHashMap.put(c, myHashMap.get(c) + 1);
            } else {
                myHashMap.put(c, 1);
            }
        }

        for(char c : ransomNote.toCharArray()) {
            if(!myHashMap.containsKey(c) || myHashMap.get(c) < 1) {
                return false;
            } else {
                myHashMap.put(c, myHashMap.get(c) - 1);
            }
        }
        return true;
    }

    public boolean canConstructWithArrays(String ransomNote, String magazine) {
        int[] magazineLetters = new int[26];

        for(int i = 0; i < magazine.length(); i++) {
            magazineLetters[magazine.charAt(i) - 'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(magazineLetters[c - 'a'] > 0) {
                magazineLetters[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void RansomNodeTest() {
        canConstructWithArrays("aa", "aab");
    }
}

