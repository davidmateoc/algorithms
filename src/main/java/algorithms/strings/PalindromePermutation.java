package algorithms.strings;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:11 PM
 * Algorithm URL: https://leetcode.com/problems/palindrome-permutation/
 */

public class PalindromePermutation {

    public static boolean canPermutePalindrome(String word) {
        int oddRepeatedChars = 0;
        int[] a = new int[128];

        for(int i = 0; i < word.length(); i++) {
            a[word.charAt(i)]++;
        }

        for(int i = 0; i< 128; i++) {
            oddRepeatedChars += a[i] % 2;
        }

        return oddRepeatedChars <= 1;
    }

    public static void main(String[] args) {
        String word = "lloo";

        System.out.println(canPermutePalindrome(word));
    }
}
