package algorithms.spotify;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 1:23 AM
 * Algorithm URL: https://leetcode.com/problems/fizz-buzz/
 */

public class fizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i%3 == 0 && i%5 == 0) {
                output.add("FizzBuzz");
            } else if(i%3 == 0 ) {
                output.add("Fizz");
            } else if(i%5 == 0) {
                output.add("Buzz");
            } else {
                output.add(String.valueOf(i));
            }
        }
        return output;
    }

    @Test
    public void fizzBuzzTest() {
        System.out.println(fizzBuzz(15));
    }
}

