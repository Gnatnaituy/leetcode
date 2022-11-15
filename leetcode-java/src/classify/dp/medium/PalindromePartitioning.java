package classify.dp.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * O(n^2)   8ms     58.28%
     * O(n)     54.3MB  37.54%
     * Back Trace + DP
     */
    private final List<List<String>> res = new ArrayList<>();

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
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * O(n^2)   6ms     99.19%
     * O(n^2)   53.9MB  50.53%
     * Back Trace + Memory
     */
    private int[][] mem;
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> temp = new ArrayList<>();

    public List<List<String>> partition2(String s) {
        mem = new int[s.length()][s.length()];
        backtrace(s, 0);
        return ans;
    }

    private void backtrace(String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end) == 1) {
                temp.add(s.substring(start, end + 1));
                backtrace(s, end + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private int isPalindrome(String s, int start, int end) {
        if (mem[start][end] != 0) {
            return mem[start][end];
        }

        if (start >= end) {
            mem[start][end] = 1;
        } else if (s.charAt(start) == s.charAt(end)) {
            mem[start][end] = isPalindrome(s, start + 1, end - 1);
        } else {
            mem[start][end] = -1;
        }

        return mem[start][end];
    }
}
