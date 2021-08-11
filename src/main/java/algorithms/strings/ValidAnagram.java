package algorithms.strings;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 8/6/21
 * Time: 2:08 AM
 * Algorithm URL: https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            letters.put(s.charAt(i), letters.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(letters.containsKey(t.charAt(i))) {
                if(letters.get(t.charAt(i)) == 1) {
                    letters.remove(t.charAt(i));
                } else {
                    letters.put(t.charAt(i), letters.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return letters.isEmpty();
    }

    public boolean isAnagramOptimized(String s, String t) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            letters[c - 'a']--;
        }

        for(int i : letters) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramOptimized2(String s, String t) {
        int[] letters = new int[26];
        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }

        for(int i : letters) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void ValidAnagramTest() {
        System.out.println(isAnagramOptimized("ab", "ba"));
    }
}

