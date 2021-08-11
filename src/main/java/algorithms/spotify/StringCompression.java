package algorithms.spotify;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 1:42 AM
 * Algorithm URL: https://leetcode.com/problems/string-compression/
 */

public class StringCompression {

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int originalLetter = 0;
        int repeatedLetter = 0;

        while(repeatedLetter < chars.length) {
            while(repeatedLetter < chars.length && chars[repeatedLetter] == chars[originalLetter]) {
                repeatedLetter++;
            }
            sb.append(chars[originalLetter]);
            sb.append((repeatedLetter - originalLetter) > 1 ? "" + (repeatedLetter - originalLetter) : "");
            originalLetter = repeatedLetter;
        }

        return sb.toString().length();
    }

    public int compressUsingInput(char[] chars) {
        int index = 0;
        int originalLetter = 0;
        int repeatedLetter = 0;

        while(repeatedLetter < chars.length) {
            while(repeatedLetter < chars.length && chars[repeatedLetter] == chars[originalLetter]) {
                repeatedLetter++;
            }
            chars[index++] = chars[originalLetter];
            if(repeatedLetter - originalLetter > 1) {
                String count = repeatedLetter - originalLetter + "";
                for(char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            originalLetter = repeatedLetter;
        }
        return index;
    }

    @Test
    public void StringCompressionTest() {
        char[] chars1 = new char[]{'a','a','b','b','c','c','c'};
        char[] chars2 = new char[]{'a'};
        char[] chars3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] chars4 = new char[]{'a','a','a','b','b','a','a'};

        System.out.println(compressUsingInput(chars1));
        System.out.println(compressUsingInput(chars2));
        System.out.println(compressUsingInput(chars3));
        System.out.println(compressUsingInput(chars4));
    }
}

