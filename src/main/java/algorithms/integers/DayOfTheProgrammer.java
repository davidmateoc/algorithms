package algorithms.integers;


import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:40 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/day-of-the-programmer
 */

public class DayOfTheProgrammer {

    public static String dayOfProgrammer(int year) {
        if(year < 1918) {
            // Julian Calendar
            if(isJulianLeapYear(year)) {
                return "12.09." + year;
            }
            return "13.09." + year;
        } else if(year > 1918) {
            // Gregorian Calendar
            if(isGregorianLeapYear(year)) {
                return "12.09." + year;
            }
            return "13.09." + year;
        } else {
            // Rare year. FebruaryDays = 15;
            return "26.09.1918";
        }
    }

    private static boolean isJulianLeapYear(int year) {
        return year%4 == 0;
    }

    private static boolean isGregorianLeapYear(int year) {
        return (year%400 == 0) || ((year%4) == 0 && (year%100) != 0);
    }

    @Test
    public void dayOfProgrammerTest() {
        Assert.assertThat(dayOfProgrammer(2016), Is.is(IsEqual.equalTo("12.09.2016")));
        Assert.assertThat(dayOfProgrammer(2017), Is.is(IsEqual.equalTo("13.09.2017")));
        Assert.assertThat(dayOfProgrammer(1800), Is.is(IsEqual.equalTo("12.09.1800")));
    }
}
