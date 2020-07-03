package classify.search.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {
    private List<String> res = new LinkedList<>();

    /**
     * 3ms 24.47%
     * 37.2MB 55.22%
     */
    public List<String> restoreIpAddresses(String s) {
        backtrace(s, "", 0, 0);

        return res;
    }

    private void backtrace(String s, String ip, int index, int blocks) {
        if (blocks > 4 || index > s.length()) {
            return;
        }

        if (index == s.length() && blocks == 4) {
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int i = 1; i < 4 && index + i <= s.length(); i++) {
            String block = s.substring(index, index + i);
            if (isValidBlock(block)) {
                ip = ip + block + ".";
                backtrace(s, ip, index + i, blocks + 1);
                ip = ip.substring(0, ip.length() - i - 1);
            }
        }
    }

    private boolean isValidBlock(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }

        int block = Integer.parseInt(s);

        return 0 <= block && block <= 255;
    }


    /**
     * 0ms
     */
    public List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();

        if (s.length() > 3 && s.length() < 13) {
            help(s, new char[s.length() + 3], 0, ans, 0, 0);
        }

        return ans;
    }

    private void help(String s, char[] cs, int count, List<String> ans, int start, int i) {
        int digit = 0;

        for (int l = start; l < 3 + start && l < s.length(); l++) {
            digit = 10 * digit + (s.charAt(l) - '0');
            if (digit > 255) return;

            cs[i++] = s.charAt(l);
            if (count == 3) {
                if (l + 1 == s.length()) {
                    ans.add(new String(cs));
                }
            } else {
                cs[i] = '.';
                help(s, cs, count + 1, ans, l + 1, i + 1);
            }

            if (digit == 0) return;
        }
    }
}