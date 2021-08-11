package algorithms.strings;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:14 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/strong-password/problem
 */

public class StrongPassword {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasNumbers = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasSpecialCharacters = false;

        int additionalCharacters = 0;
        char[] passChars = password.toCharArray();

        for(char passChar : passChars) {
            if(numbers.contains(Character.toString(passChar))) {
                hasNumbers = true;
            }
            if(lower_case.contains(Character.toString(passChar))) {
                hasLowercase = true;
            }
            if(upper_case.contains(Character.toString(passChar))) {
                hasUppercase = true;
            }
            if(special_characters.contains(Character.toString(passChar))) {
                hasSpecialCharacters = true;
            }
        }

        if(!hasNumbers)
            additionalCharacters++;
        if(!hasLowercase)
            additionalCharacters++;
        if(!hasUppercase)
            additionalCharacters++;
        if(!hasSpecialCharacters)
            additionalCharacters++;


        while(password.length() + additionalCharacters < 6) {
            additionalCharacters++;
        }

        return additionalCharacters;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(3, "Ab1"));
    }
}
