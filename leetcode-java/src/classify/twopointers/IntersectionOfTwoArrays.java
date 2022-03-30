package classify.twopointers;

import java.util.*;

public class IntersectionOfTwoArrays {

    /**
     * 5ms 80.76%
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j] && !result.contains(nums1[i])) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        int[] intResult = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intResult[k] = result.get(k);
        }

        return intResult;
    }

    /**
     * 4ms 89.86%
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int num : nums1) hashSet.add(num);
        for (int num : nums2) {
            if (hashSet.contains(num)) {
                resSet.add(num);
            }
        }

        int[] res = new int[resSet.size()];

        Iterator<Integer> iterator = resSet.iterator();
        for (int i = 0; i < res.length; i++) {
            res[i] = iterator.next();
        }

        return res;
    }

    /**
     * 1ms      99.21%
     * 41.7MB   8.63%
     */
    public int[] intersection4(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        for (int num : nums1) {
            hash[num] = 1;
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (hash[num] == 1) {
                res.add(num);
                hash[num] = 0;
            }
        }

        int[] ans = new int[res.size()];
        Iterator<Integer> iterator = res.iterator();
        for (int i = 0; i < res.size(); i++) {
            ans[i] = iterator.next();
        }

        return ans;
    }
}
