package discover.datastructure.hashtable;


import java.util.*;

/**
 * 347 前K个高频元素
 */
public class TopKFrequentElements {

    /**
     * 92ms 20.50%
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Iterator<Map.Entry<Integer, Integer>> iterator = list.iterator(); iterator.hasNext() && k > 0; k--)
            res.add(iterator.next().getKey());

        return res;
    }

    /**
     * 14ms
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for (int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }

        return ret;
    }
}
