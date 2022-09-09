package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DoubleWeeklyContest86 {

    public boolean findSubarrays(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        Set<Integer> sums = new HashSet<>();
        sums.add(nums[0] + nums[1]);
        for (int i = 1; i < nums.length - 1; i++) {
            if (sums.contains(nums[i] + nums[i + 1])) {
                return true;
            } else {
                sums.add(nums[i] + nums[i + 1]);
            }
        }

        return false;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (!isPalindronmic(transfer(n, i))) {
                return false;
            }
        }

        return true;
    }

    private String transfer(int n, int base) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            res.append(n % base);
            n /= base;
        }

        return res.reverse().toString();
    }

    private boolean isPalindronmic(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public int maximumRows(int[][] mat, int cols) {
        int row = mat.length, col = mat[0].length;
        int[][] count = new int[col][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j ++) {
                count[i][1] += mat[i][j];
            }
        }
        
        while (cols > 0) {
            Arrays.sort(count, (o1, o2) -> o1[1] - o2[1]);
              
        }
    }

    public static void main(String[] args) {
        DoubleWeeklyContest86 a = new DoubleWeeklyContest86();
        System.out.println(a.isStrictlyPalindromic(9));
    }
}
