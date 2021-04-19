package classify.sort;

import java.util.Arrays;

/**
 * @author yutiantang
 * @create 2021/4/19 23:16
 */
public class MaxiumGap {

    /**
     * 2ms      99.84%
     * 38.7MB   55.76%
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int slow = 0, fast = 1, max = Integer.MIN_VALUE;
        while (fast < nums.length) {
            max = Math.max(max, nums[fast] - nums[slow]);
            slow++;
            fast++;
        }

        return max;
    }

    /**
     * 5ms      36.65%
     * 38.5MB   75.43%
     * 官方题解 基数排序
     * @param nums
     * @return
     */
    public int maximumGap2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        long exp = 1;
        int[] buffer = new int[len];
        int max = Arrays.stream(nums).max().getAsInt();

        while (max >= exp) {
            int[] cnt = new int[10];
            for (int num : nums) {
                int digit = (num / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buffer[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, len);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < len; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }

        return ret;
    }

    /**
     * 6ms      24.57%
     * 38.5MB   77.80%
     * 官方题解 桶排序
     * @param nums
     * @return
     */
    public int maximumGap3(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int min  = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (max - min) / (len - 1));
        int bucketSize = (max - min) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            Arrays.fill(bucket[i], -1);
        }
        for (int num : nums) {
            int index = (num - min) / d;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = num;
            } else {
                bucket[index][0] = Math.min(bucket[index][0], num);
                bucket[index][1] = Math.max(bucket[index][1], num);
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }

        return ret;
    }
}
