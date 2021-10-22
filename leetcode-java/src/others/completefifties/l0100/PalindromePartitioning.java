package others.completefifties.l0100;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> res;

    /**
     * 6ms 92.73%
     * 40.02MB 90.09%
     */
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;

        List<String> list = new ArrayList<>();
        findPalindrome(s, 0, list);

        return res;
    }

    private void findPalindrome(String s, int start, List<String> list) {
        if (start >= s.length())
            res.add(new ArrayList<>(list));

        for (int size = 1; start + size <= s.length(); size++) {
            String temp = s.substring(start, start + size);
            if (isPalindrome(temp)) {
                list.add(temp);
                findPalindrome(s, start + size, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end])
                return false;
            start++;
            end--;
        }

        return true;
    }
}
