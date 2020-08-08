package contest;

import java.util.Arrays;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/2 10:25
 * @Description Week200
 */
public class Week200 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;

        if (arr == null || arr.length < 3) return res;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) < a && Math.abs(arr[j] - arr[k]) < b && Math.abs(arr[i] - arr[k]) < c) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public int getWinner(int[] arr, int k) {
        if (k > arr.length - 1) {
            Arrays.sort(arr);
            return arr[arr.length - 1];
        } else {
            int max = arr[0];
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (max != arr[i]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == k) return max;
            }
            return max;
        }
    }

    public int minSwaps(int[][] grid) {
        return 0;
    }

    public int maxSum(int[] nums1, int[] nums2) {
        if (nums1[0] > nums2[0]) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        long max = 0;
        int cur1 = 0;
        int cur2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        while (cur1 < nums1.length && cur2 < nums2.length) {
            if (nums1[cur1] < nums2[cur2]) {
                sum1 += nums1[cur1++];
            } else if (nums1[cur1] > nums2[cur2]) {
                sum2 += nums2[cur2++];
            } else {
                max += Math.max(sum1 + nums1[cur1++], sum2 + nums2[cur2++]);
                sum1 = 0;
                sum2 = 0;
            }
        }

        while (cur1 < nums1.length) sum1 += nums1[cur1++];
        while (cur2 < nums2.length) sum2 += nums2[cur2++];
        max += Math.max(sum1, sum2);

        return (int) (max % 1000000007L);
    }
}
