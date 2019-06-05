package java.others.discover.algorithm.elementary.designproblem;


import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组
 */
public class ShuffleAnArray {

    /**
     * 297ms 44.98%
     * 63.8m 56.52%
     */
    private int[] origin;
    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.origin = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length / 2; i++) {
            // 每次只需拿第一个元素进行交换即可
            swap(nums, 0, random.nextInt(nums.length));
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



class Solution {
    /**
     * 165ms
     */
    private int[] p;

    public Solution(int[] nums) {
        p = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return p;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = p.length;
        int[] q = new int[len];
        System.arraycopy(p, 0, q, 0, len);
        int pos;//记录要交换元素的位置
        int temp; //记录要交换的值
        Random ran = new Random();
        for(int i = len - 1; i >= 0; i--){
            pos = ran.nextInt(i + 1);
            temp = q[pos];
            q[pos] = q[i];
            q[i] = temp;
        }

        return q;
    }
}
