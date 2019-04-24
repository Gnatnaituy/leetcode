package others.discover.algorithm.elementary.array;

import java.util.*;


/**
 * 给定两个数组，编写一个函数来计算它们的交集
 */
public class IntersectionOfTwoArraysII {

    /**
     * 7ms 57.26%
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
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

    public int[] intersect2(int[] nums1, int[] nums2) {
        /*
        4ms
         */
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        for (Integer num : nums1 ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                result.add(num);
                map.put(num, count - 1);
            }
        }

        int[] array = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            array[i++] = num;
        }

        return array;
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        /*
        1ms
         */
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
        int len1 = 0;
        boolean[] bl1 = new boolean[ret1.length];

        for (int i1 : nums2) {
            int start = 0;
            while ((start = find(nums1, i1, start)) != -1) {
                if (!bl1[start]) {
                    ret1[len1++] = i1;
                    bl1[start] = true;
                    break;
                }
                start++;
            }
        }

        return Arrays.copyOfRange(ret1, 0, len1);
    }

    private int find(int[] nums, int val, int start) {
        for (; start < nums.length; start++) {
            if (nums[start] == val) {
                return start;
            }
        }
        return -1;
    }
}