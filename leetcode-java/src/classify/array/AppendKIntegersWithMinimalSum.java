package classify.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AppendKIntegersWithMinimalSum {

    /**
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum(int[] nums, int k) {
        long res = 0, cur = 1;
        Arrays.sort(nums);

        for (int i = 0; k > 0; ) {
            if (i == nums.length || cur != nums[i]) {
                res += cur;
                k--;
                cur++;
            } else {
                i++;
                cur = i == nums.length || cur != nums[i] ? cur + 1 : cur;
            }
        }

        return res;
    }

    /**
     * 可能漏掉一些需要替换的值
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum2(int[] nums, int k) {
        int res = (k + 1) * k / 2;
        res += (k % 2) == 1 ? (k + 1) / 2 : 0;
        HashMap<Integer, Integer> uniques = new HashMap<>();

        for (int num : nums) {
            if (!uniques.containsKey(num)) {
                if (num <= k) {
                    res += k - num + 1;
                    k++;
                }
                uniques.put(num, 1);
            } else {
                if (num <= k) {
                    res += k - num + uniques.get(num) + 1;
                    uniques.put(num, uniques.get(num) + 1);
                }
            }
        }

        return res;
    }

    /**
     * 还是超时
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum3(int[] nums, int k) {
        long res = 0, cur = 1;
        int i = 0, len = nums.length;
        Arrays.sort(nums);

        while (k > 0) {
           if (i == len) {
               break;
           }
           if (cur != nums[i]) {
               res += cur;
               k--;
               cur++;
           } else {
               while (i < len && cur == nums[i]) {
                   i++;
               }
               cur = i == len|| cur != nums[i] ? cur + 1 : cur;
           }
        }

        if (k > 0) {
            res += (cur - 1) * k + (long) (k + 1) * k / 2;
        }

        return res;
    }

    /**
     * 41ms     100.00%
     * 57.8MB   100.00%
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum4(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num: nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            set.add(num);
        }

        return (long) (1 + k) * k / 2 - sum;
    }

    public static void main(String[] args) {
        minimalKSum3(new int[]{5,6}, 7);
    }
}
