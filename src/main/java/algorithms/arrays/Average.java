package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 10:33 PM
 * Algorithm URL:
 */

public class Average {

    public int getAverage(int[] marks){
        int total = 0;
        for(int mark : marks) {
            total += mark;
        }

        return total/marks.length;
    }

    @Test
    public void AverageTest() {
        int[] marks = {10, 5, 6, 7};
        getAverage(marks);
    }
}

