package java.others.discover.algorithm.elementary.sortandsearch;


/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 */
public class MergeSortedArray {

    /**
     * 5ms 68.74%
     * 27.9 59.14%
     * 合并后的 nums1 的有效长度为 m + n
     * 所以可以从后向前取 nums1 和 nums2 中较大的数值
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        m--;
        n--;

        while (cur > -1) {
            if (m == -1) nums1[cur--] = nums2[n--];
            else if (n == -1) nums1[cur--] = nums1[m--];
            else nums1[cur--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }
}
