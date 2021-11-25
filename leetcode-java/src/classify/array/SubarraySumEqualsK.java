package classify.array;

import java.util.HashMap;

/**
 * @Author tiantang
 * @Date 2021/11/25
 */
public class SubarraySumEqualsK {

    /**
     * 1067ms   36.79%
     * 41.6MB   25.79%
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int res = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == k) {
                res++;
            }
            if (fast > 0) {
                for (int slow = 0; slow < fast; slow++) {
                    if (nums[fast] - nums[slow] == k) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 21ms     91.96%
     * 40.7MB   77.88%
     * 利用哈希表实现线性寻找
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int i;
        int sum = 0;
        int count = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {   // 表示连续子数组减去连续子数组，必定为连续子数组
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
