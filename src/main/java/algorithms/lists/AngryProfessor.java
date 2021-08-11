package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/13/21
 * Time: 10:26 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/angry-professor
 */

public class AngryProfessor {

    public static String angryProfessor(int k, List<Integer> a) {
        int onTimeStudents = 0;
        for(int student : a) {
            if(student <= 0) {
                onTimeStudents++;
            }
        }
        return (onTimeStudents >= k)? "NO" : "YES";
    }

    @Test
    public void AngryProfessorTest() {
        Assert.assertThat(angryProfessor(3, List.of(-1, -3, 4, 2)), Is.is(IsEqual.equalTo("YES")));
        Assert.assertThat(angryProfessor(2, List.of(0, -1, 2, 1)), Is.is(IsEqual.equalTo("NO")));
    }
}

