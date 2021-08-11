package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ToLowerCase {

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    @Test
    public void toLowerCaseTest() {
        assertThat(toLowerCase("HellO"), is(equalTo("hello")));
    }
}
