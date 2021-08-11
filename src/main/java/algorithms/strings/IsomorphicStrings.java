package algorithms.strings;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 8/4/21
 * Time: 2:58 AM
 * Algorithm URL: https://leetcode.com/problems/isomorphic-strings/
 */

public class IsomorphicStrings {

    public boolean isIsomorphicA(String s, String t) {
        return isIsomorphicLogic(s, t) && isIsomorphicLogic(t, s);
    }

    public boolean isIsomorphicLogic(String s, String t) {
        HashMap<Character, Character> myLetters = new HashMap<>();
        if(s.length() != t.length()) {
            return false;
        }

        StringBuilder modifiedS = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(myLetters.containsKey(s.charAt(i))) {
                modifiedS.append(myLetters.get(s.charAt(i)));
            } else {
                myLetters.put(s.charAt(i), t.charAt(i));
                modifiedS.append(t.charAt(i));
            }
        }
        return modifiedS.toString().equals(t);
    }

    public boolean isIsomorphicB(String s, String t) {
        return transform(s).equals(transform(t));
    }

    public String transform(String s) {
        HashMap<Character, Integer> myLetters = new HashMap<>();

        StringBuilder modifiedS = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(!myLetters.containsKey(s.charAt(i))) {
                myLetters.put(s.charAt(i), i);
            }
            modifiedS.append("" + myLetters.get(s.charAt(i)));
            modifiedS.append(" ");
        }
        return modifiedS.toString();
    }

    @Test
    public void IsomorphicStringsTest() {

    }
}

