package huahua.dp;

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
}
