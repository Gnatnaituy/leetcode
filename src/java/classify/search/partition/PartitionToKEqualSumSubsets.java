package java.classify.search.partition;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    /**
     * 34ms 36.58%
     * 33.7MB 100%
     * Search by Constructing Subset Sums
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;

        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;

        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }

        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;

        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }

        return false;
    }


    /**
     * Dynamic Programming on Subsets of Input
     * 看不懂...
     */
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;

        int[] memo = new int[1 << nums.length];
        memo[(1 << nums.length) - 1] = 1;

        return search(0, sum, memo, nums, sum / k);
    }

    private boolean search(int used, int todo, int[] memo, int[] nums, int target) {
        if (memo[used] == 0) {
            memo[used] = -1;
            int tar = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= tar) {
                    if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                        memo[used] =1;
                        break;
                    }
                }
            }
        }

        return memo[used] == 1;
    }
}
