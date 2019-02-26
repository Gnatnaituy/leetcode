package others.easy.etwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349 Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */

public class IntersectionOfTwoArrays {

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
        for (int k = 0; k < result.size(); k++)
            intResult[k] = result.get(k);

        return intResult;
    }
}
