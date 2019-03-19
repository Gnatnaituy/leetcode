package discover.datastructure.binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int len = nums.length;
        int low = 0;                        // 预估结果的下界
        int high = nums[len - 1] - nums[0]; // 预估结果的上界

        while (low < high) {
            int mid = low + (high - low) >> 2;
            int j = 0, count = 0;

            for (int i = 0; i < len; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                count += i - j;
            }

            if (count < k) low = mid + 1;
            else high = mid;
        }

        return low;
    }
}
