package classify.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/3/30 10:02 PM
 */
public class IntersectionOfTwoArraysII {

    /**
     * 3ms      69.36%
     * 38.6MB   63.30%
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int cur1 = 0, cur2 = 0;
        while (cur1 < nums1.length && cur2 < nums2.length) {
            if (nums1[cur1] == nums2[cur2]) {
                int same = nums1[cur1];
                res.add(same);
            } else if (nums1[cur1] < nums2[cur2]) {
                cur1++;
            } else {
                cur2++;
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for (int element : res) {
            ans[i++] = element;
        }

        return ans;
    }
}
