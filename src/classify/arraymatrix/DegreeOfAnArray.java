package classify.arraymatrix;

import java.util.*;

public class DegreeOfAnArray {

    /**
     * 14ms 81.53%
     * 37.7MB 99.96%
     */
    public int findShortestSubarray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] info = map.get(nums[i]);
                info[1] = i;
                info[2] += 1;
            } else {
                map.put(nums[i], new int[]{i, i, 1});
            }
        }

        int degree = 0;
        int[] max = new int[]{0, 0, 0};

        for (int[] value : map.values()) {
            if (value[2] > degree) {
                degree = value[2];
                max = value;
            } else if (value[2] == degree) {
                max = max[1] - max[0] > value[1] - value[0] ? value : max;
            }
        }

        return max[1] - max[0] + 1;
    }
}
