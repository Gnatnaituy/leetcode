package classify.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author yutiantang
 * @create 2021/4/21 22:24
 */
public class ContainsDuplicateIII {

    /**
     * 56ms     12.23%
     * 40.3MB   55.37%
     * 官方题解 滑动窗口 + 有序集合
     * O(n) = O(nlog(min(n,k))) 其中 nn 是给定数组的长度。
     *                          每个元素至多被插入有序集合和从有序集合中删除一次，
     *                          每次操作时间复杂度均为 O(log(min(n, k))
     * T(n) = O(min(n,k)) 其中 nn 是给定数组的长度。
     *                    有序集合中至多包含 min(n, k + 1)个元素
     * @param nums 0 <= nums.length <= 2 * 10^4
     *             -2^31 <= nums[i] <= 2^31 - 1
     * @param k 0 <= k <= 10^4
     * @param t 0 <= t <= 2^31 - 1
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i] - t 总是小于 0
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            // ceiling 的 index 总是小于 i
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 窗口长度为 k
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    /**
     * 22.9ms   88.45%
     * 41.8MB   7.12%
     * 官方题解 桶
     * O(n) = O(n)
     * T(n) = O(min(n,k))
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }

        return (x + 1) / w - 1;
    }
}
