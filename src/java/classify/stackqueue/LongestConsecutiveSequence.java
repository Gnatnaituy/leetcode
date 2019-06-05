package java.classify.stackqueue;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    /**
     * 900ms 5.03%
     * 37.7MB 50.89%
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int lower = map.getOrDefault(num - 1, 0);
            int bigger = map.getOrDefault(num + 1, 0);
            map.put(num, lower + bigger + 1);
            update(map, num, -1);
            update(map, num, 1);
            res = Math.max(res, map.get(num));
        }

        return res;
    }

    private void update(HashMap<Integer, Integer> map, int num, int step) {
        if (map.containsKey(num + step)) {
            map.put(num + step, map.get(num));
            update(map, num + step, step);
        }
    }

    /**
     * 7ms 57.75%
     * 35.5MB 82.15%
     * 只需要连续序列的两端保持最大值即可
     */
    public int longestConsecutive2(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }

        return res;
    }

    /**
     * 3ms
     * 直接排序还快一点LOL
     */
    public int longestConsecutive3(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int longest = 1;
        int curr = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                if(nums[i] == nums[i-1] + 1) {
                    curr += 1;
                } else {
                    longest = Math.max(longest, curr);
                    curr = 1;
                }
            }
        }

        return Math.max(longest, curr);
    }
}
