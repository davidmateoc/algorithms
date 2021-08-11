package algorithms.integers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:41 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/fizzbuzz/problem
 */

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> myList = new ArrayList();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                myList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                myList.add("Fizz");
            } else if (i % 5 == 0) {
                myList.add("Buzz");
            } else {
                myList.add(""+ i);
            }
        }

        return myList;
    }

    @Test
    public void fizzBuzzTest() {
        List<String> result = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assertThat(fizzBuzz(15), is(equalTo(result)));
    }
}
