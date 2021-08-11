package algorithms.strings;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:06 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/camelcase
 */

public class CamelCase {

    static int camelcase(String s) {
        int mayus = 0;
        char[] sChars = s.toCharArray();
        for(char c : sChars) {
            if(Character.isUpperCase(c)) {
                mayus++;
            }
        }
        return mayus + 1;
    }


    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        System.out.println(camelcase(s));
    }
}
