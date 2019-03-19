package discover.datastructure.binarysearch;


import java.util.*;

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
     * 复制arr, 将每个元素替换为与x差的绝对值
     * 找到最小的那个绝对值
     * 找到附近的k个元素
     * <p>
     * Not working
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < arrCopy.length; i++) {
            arrCopy[i] = Math.abs(arrCopy[i] - x);
        }

        int left = 0;
        int right = arrCopy.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arrCopy[mid] < arrCopy[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left <= k / 2 + 1) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if (arr.length - left <= (k + 1) / 2) {
            for (int i = arrCopy.length - k; k > 0; i++) {
                res.add(arr[i]);
                k--;
            }
        } else {
            for (int i = left - k / 2; k > 0; i++) {
                res.add(arr[i]);
                k--;
            }
        }

        return res;
    }

    /**
     * 15ms 53.39%
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k; // 首位指针范围以k为单位
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
