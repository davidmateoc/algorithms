package algorithms.strings;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:17 PM
 * Algorithm URL: https://leetcode.com/problems/backspace-string-compare/
 */

public class BackspaceStringCompare {

    public boolean backspaceStringCompare(String S, String T) {
        List<Character> lS = new ArrayList();
        List<Character> lT = new ArrayList();

        for(char c : S.toCharArray()){
            if(lS.isEmpty() && c=='#'){continue;} else if(c == '#') {
                lS.remove(lS.size()-1);

            } else {
                lS.add(c);
            }
        }

        for(char c : T.toCharArray()) {
            if(lT.isEmpty() && c== '#') {continue;} else if (c == '#') {
                lT.remove(lT.size() -1);
            } else {
                lT.add(c);
            }
        }

        return lS.equals(lT);
    }

    @Test
    public void backspaceStringCompareTest() {
        assertTrue(backspaceStringCompare("a##c", "#a#c"));
    }
}
