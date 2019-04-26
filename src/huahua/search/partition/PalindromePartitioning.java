package huahua.search.partition;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> res = new ArrayList<>();

    /**
     * 3ms 81.45%
     * 41.1MB 15.34%
     */
    public List<List<String>> partition(String s) {
        backtrace(s, new ArrayList<>(), 0);

        return res;
    }

    private void backtrace(String s, List<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s.substring(start, end))) {
                list.add(s.substring(start, end));
                backtrace(s, list, end);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
