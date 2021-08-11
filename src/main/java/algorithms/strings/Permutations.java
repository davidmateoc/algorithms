package algorithms.strings;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:11 PM
 * Algorithm URL: https://leetcode.com/problems/permutations/
 */

public class Permutations {


    public static void permutation(String input) {
        permutation("", input);
    }

    public static void permutation(String perm, String word) {
        if(word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for(int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }


    public static void main(String[] args) {
        permutation("123");
    }
}
