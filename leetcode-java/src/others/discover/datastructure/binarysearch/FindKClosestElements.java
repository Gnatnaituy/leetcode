package others.discover.datastructure.binarysearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 658 找到K个最接近的元素
 * <p>
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数
 * <p>
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 */
public class FindKClosestElements {

    /**
     * 15ms 53.39%
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k; // 首位指针范围以k为单位
        List<Integer> res = new ArrayList<>();

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 若前者大，则x应在mid右侧
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}
