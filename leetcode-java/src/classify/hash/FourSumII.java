package classify.hash;


import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    /**
     * 108ms    98.66%
     * 41.4MB   44.40%
     */
    public int fourSunCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : nums3) {
            for (int d : nums4) {
                int s = c + d;
                map.put(s, map.getOrDefault(s, 0) + 1);

            }
        }

        int res = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                int d = -a - b;
                res += map.getOrDefault(d, 0);
            }
        }

        return res;
    }
}
