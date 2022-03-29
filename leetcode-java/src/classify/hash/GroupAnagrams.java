package classify.hash;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    /**
     * 6ms      86.06%
     * 44.2MB   48.25%
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }

    /**
     * 9ms      30.83%
     * 43.8MB   69.89%
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }))
                .values());
    }
}
