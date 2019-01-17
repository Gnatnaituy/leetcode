package medium.afifty;

/**
 * 4. Median of Two sorted Arrays
 */

public class MedianOfTwoSortedArrays {
    
    // 73ms 51.28% O((m + n) / 2)
//    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len = nums1.length + nums2.length;
//        int cur1 = 0, cur2 = 0, i = 0;
//        int[] nums = new int[len];
//
//        while (i <= len / 2) {
//            if (cur1 < nums1.length && cur2 < nums2.length) {
//                nums[i++] = nums1[cur1] < nums2[cur2] ? nums1[cur1++] : nums2[cur2++];
//            } else if (cur1 == nums1.length) {
//                nums[i++] = nums2[cur2++];
//            } else {
//                nums[i++] = nums1[cur1++];
//            }
//        }
//
//        return len % 2 == 0 ? (nums[len / 2] + nums[len / 2 - 1]) / 2.0 : (double) nums[len / 2];
//    }
    
    
    // official solution O(log(min(m, n)))
//    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // make sure nums1.length <= nums2.length
//        if (nums1.length > nums2.length) {
//            int[] temp = nums1; nums1 = nums2; nums2 = temp;
//        }
//        int m = nums1.length, n = nums2.length;
//        int min = 0, max = m, halfLen = (m + n + 1) / 2;
//
//        while (min < max) {
//            int i = (min + max) / 2;
//            int j = halfLen - i;
//
//            if (i < max && nums2[j - 1] > nums1[i]) {
//                min = i + 1; // i is too small
//            } else if (i > min && nums1[i - 1] > nums2[j]) {
//                max = i - 1; // i is too big
//            } else {
//                int maxLeft = 0;
//                if (i == 0) {maxLeft = nums2[j - 1];}
//                else if (j == 0) {maxLeft = nums1[i - 1];}
//                else {maxLeft = Math.max(nums1[i - 1], nums1[j - 1]);
//                if ((m + n) % 2 == 1) return maxLeft;
//
//
//            }
//        }
//    }
}
