package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 8:50 PM
 * Algorithm URL: https://leetcode.com/problems/defanging-an-ip-address/
 */

public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    @Test
    public void defangIPaddrTest() {
        final String a = "127.0.0.1";

        final String aExpected = "127[.]0[.]0[.]1";
        assertThat(defangIPaddr(a), is(equalTo(aExpected)));
    }
}
