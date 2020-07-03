package classify.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * 0ms 100.00%
     * 37.9MB 14.08%
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            // 寻找将num插入到dp数组中索引位置,查找范围[0,len)
            int i = binarySearch(dp, len, num);
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }

        return len;
    }

    private int binarySearch(int[] a, int r, int target) {
        int start = 0;
        int end = r - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int midval = a[mid];
            if (midval < target) {
                start = mid + 1;
            } else if (midval > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return start;
    }

    /**
     * 10ms
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        
        int res = 1;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    tempMax = Math.max(tempMax, dp[j]);
            }
            dp[i] = tempMax + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 16ms 21.00%
     * 36.2MB 57.84%
     */
    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }

        return res;
    }

    /**
     * 2ms
     */
    public int lengthOfLIS4(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }

        return size;
    }
}
