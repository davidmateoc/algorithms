package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/time-conversion
 */

public class TimeConversion {

    public static String timeConversion(String s) {
        String hour = s.substring(0, 2);

        if(s.charAt(8) == 'A') {
            if(hour.equals("12")) {
                hour = "00";
            }
        } else {
            if(!hour.equals("12")) {
                hour = String.valueOf(Integer.parseInt(hour) + 12);
            }
        }
        return hour + s.substring(2, 8);
    }

    @Test
    public void timeConversionTest() {
        Assert.assertThat(timeConversion("07:05:45PM"), Is.is(IsEqual.equalTo("19:05:45")));
        Assert.assertThat(timeConversion("12:01:00PM"), Is.is(IsEqual.equalTo("12:01:00")));
        Assert.assertThat(timeConversion("12:01:00AM"), Is.is(IsEqual.equalTo("00:01:00")));
    }
}
