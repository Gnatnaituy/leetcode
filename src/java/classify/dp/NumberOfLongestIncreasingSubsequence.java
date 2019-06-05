package java.classify.dp;

public class NumberOfLongestIncreasingSubsequence {

    /**
     * 9ms 82.29%
     * 38.4MB 95.80%
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int maxLen = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }

            if (maxLen == len[i]) {
                res += cnt[i];
            } else if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }

        return res;
    }
}
