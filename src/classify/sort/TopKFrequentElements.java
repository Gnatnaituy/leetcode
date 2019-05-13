package classify.sort;

import java.util.*;

public class TopKFrequentElements {

    /**
     * 44ms 32.41%
     * 40MB 74.02%
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> keyValues = new ArrayList<>(map.entrySet());
        keyValues.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(keyValues.get(i).getKey());
        }

        return res;
    }

    /**
     * 桶排序
     * 10ms
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : count.keySet()) {
            int times = count.get(num);
            if (bucket[times] == null)
                bucket[times] = new ArrayList<>();
            bucket[times].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;
    }
}
