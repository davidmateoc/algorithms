package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:41 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/grading
 */

public class GradingStudents {
//    83 + 5-83%5

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if ((5 - grade % 5 < 3) && grade > 37) {
                roundedGrades.add(grade + 5 - grade % 5);
            } else {
                roundedGrades.add(grade);
            }
        }
        return roundedGrades;
    }

    @Test
    public void gradingStudentsTest() {
        List<Integer> grades = List.of(73, 67, 38, 33);
        Assert.assertThat(gradingStudents(grades), Is.is(IsEqual.equalTo(List.of(75, 67, 40, 33))));
    }
}
