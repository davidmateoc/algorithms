package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:24 PM
 * Algorithm URL: https://leetcode.com/problems/license-key-formatting/
 */

public class LicenceKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("[-]", "");
        S = S.toUpperCase();

        if(S.length() <= K) {
            return S;
        }

        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for(int i = S.length() - 1; i >= 0; i--) {
            sb.append(S.charAt(i));
            counter++;
            if(counter == K && i != 0) {
                sb.append("-");
                counter = 0;
            }
        }
        return sb.reverse().toString();
    }

    public String licenseKeyFormattingII(String S, int K) {
        S = S.replaceAll("[-]", "");
        S = S.toUpperCase();

        if(S.length() <= K) {
            return S;
        }

        StringBuilder sb = new StringBuilder(S);

        for(int i = S.length() - K; i > 0; i= i - K) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }

    @Test
    public void licenseKeyFormattingTest() {
        assertThat(licenseKeyFormatting("5F3Z-2e-9-w", 4), is(equalTo("5F3Z-2E9W")));
        assertThat(licenseKeyFormatting("2-5g-3-J", 2), is(equalTo("2-5G-3J")));

        assertThat(licenseKeyFormattingII("5F3Z-2e-9-w", 4), is(equalTo("5F3Z-2E9W")));
        assertThat(licenseKeyFormattingII("2-5g-3-J", 2), is(equalTo("2-5G-3J")));
    }
}
