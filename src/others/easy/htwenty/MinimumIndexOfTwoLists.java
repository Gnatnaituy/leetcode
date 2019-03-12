package others.easy.htwenty;

import java.util.*;

/**
 * 599 Minimum Index of Two Lists
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 *
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */

public class MinimumIndexOfTwoLists {

    /**
     * 85ms 16.40%
     */
    private String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        HashMap<String, Integer> hashMap11 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) hashMap1.put(i, list1[i]);
        for (int i = 0; i < list2.length; i++) hashMap2.put(list2[i], i);
        for (int i = 0; i < list1.length; i++) hashMap11.put(list1[i], i);

        for (int i = 0; i < list1.length; i++) {
            if (hashMap2.containsKey(hashMap1.get(i))) {
                res.add(hashMap1.get(i));
                indexes.add(i + hashMap2.get(hashMap1.get(i)));
            }
        }

        indexes.sort((o1, o2) -> o1 < o2 ? 1 : 0);
        int minIndex = indexes.get(0);

        List<String> aaa = new ArrayList<>();
        for (String re : res) {
            if (hashMap11.get(re) + hashMap2.get(re) == minIndex)
                aaa.add(re);
        }

        String[] finalRes = new String[aaa.size()];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = aaa.get(i);
        }

        return finalRes;
    }

    /**
     * 30ms 69.43%
     */
    private static String[] findRestaurant2(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> mapOfList1 = new HashMap<>();
        List<String> restaurants = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            mapOfList1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (mapOfList1.containsKey(list2[i])) {
                int distance = i + mapOfList1.get(list2[i]);
                if (distance > min) continue;
                if (distance < min) {
                    min = distance;
                    restaurants = new ArrayList<>();
                }
                restaurants.add(list2[i]);
            }
        }

        String[] res = new String[restaurants.size()];
        for (int i = 0; i < res.length; i++) res[i] = restaurants.get(i);

        return res;
    }

    /**
     * 16ms
     */
    public String[] findRestaurant3(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        int min = list1.length + list2.length;
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        for (int j = 0; j < list2.length && j <= min; j++){
            if (map.containsKey(list2[j])){
                int sum = j + map.get(list2[j]);
                if (sum < min){
                    // 发现索引和更小的元素
                    min = sum;
                    list.clear();
                    list.add(list2[j]);
                } else if (sum == min){
                    list.add(list2[j]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
