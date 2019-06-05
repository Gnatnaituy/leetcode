package java.others.easy.etwenty;

import java.util.*;

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
        for (int k = 0; k < result.size(); k++)
            intResult[k] = result.get(k);

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
     * 1ms
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        int max = Integer.MIN_VALUE;
        for (int i1 : nums1) {
            if (i1 > max) {
                max = i1;
            }
        }

        for (int i1 : nums2) {
            if (i1 > max) {
                max = i1;
            }
        }

        int count = 0;
        int[] book = new int[max + 1];
        for (int i1 : nums1) {
            if (book[i1] == 0)
                book[i1]++;
        }

        for (int i1 : nums2) {
            if (book[i1] == 1) {
                book[i1]++;
                count++;
            }
        }

        int[] testan = new int[count];
        List<Integer> list = new ArrayList<>();
        for (int i = 0,j=0; i < book.length; i++) {
            if (book[i] > 1) {
                testan[j++] = i;
            }
        }

        return  testan;
    }
}
