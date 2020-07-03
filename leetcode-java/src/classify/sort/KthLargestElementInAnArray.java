package classify.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /**
     * 排序 T(n) = O(NlogN) S(n) = O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    /**
     * 7ms 56.49%
     * 36.8MB 94.77%
     * 堆排序 T(n) = O(NlogK) S(n) = O(K)
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }

        return queue.peek();
    }

    /**
     * 快排 T(n) = O(N) S(n) = O(1)
     */
    public int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int j = partition(nums, left, right);
            if (j == k) break;
            else if (j < k) left = j + 1;
            else right = j - 1;
        }

        return nums[k];
    }

    private int partition(int[] a, int left, int right) {
        int i = left;
        int j = right + 1;

        do {
            while (a[++i] < a[left] && i < right);
            while (a[--j] > a[left] && j > left);
        } while (i < j);
        swap(a, left, j);

        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
