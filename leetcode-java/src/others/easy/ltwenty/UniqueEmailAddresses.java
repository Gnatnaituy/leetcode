package others.easy.ltwenty;

import java.util.*;

/**
 * 929 Unique Email Addresses
 */

public class UniqueEmailAddresses {

    private int numUniqueEmails(String[] emails) {
        
        // 43ms 75.52%
        // Change List to Set 22ms 93.63%
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        
        for (String email : emails) {
            sb = new StringBuilder();
            String[] emailSplit = email.split("@");
            for (char c : emailSplit[0].toCharArray()) {
                if (c == '.') continue;
                if (c == '+') break;
                else sb.append(c);
            }
            String prettyEmail = sb.toString() + emailSplit[1];
    
            set.add(prettyEmail);
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int res = new UniqueEmailAddresses().numUniqueEmails(emails);
    }
}
