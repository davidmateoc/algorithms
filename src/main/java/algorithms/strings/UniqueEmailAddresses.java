package algorithms.strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:29 PM
 * Algorithm URL: https://leetcode.com/problems/unique-email-addresses/
 */

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet();

        for(String email : emails) {
            String[] emailParts = email.split("@");
            String localName = emailParts[0];
            String domain = emailParts[1];

            localName = localName.replaceAll("[.]", "");
            localName = localName.replaceAll("\\+.*", "");

            String transformedEmail = localName + "@" + domain;
            if(!uniqueEmails.contains(transformedEmail)) {
                uniqueEmails.add(transformedEmail);
            }
        }
        return uniqueEmails.size();
    }


    @Test
    public void numUniqueEmailsTest() {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        assertThat(numUniqueEmails(emails), is(equalTo(3)));
    }
}
