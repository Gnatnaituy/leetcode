package classify.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    /**
     * 50ms 36.88%
     * 37.9MB 98.74%
     */
    public String frequencySort(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencies.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        StringBuilder res = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }

    /**
     * 3ms
     */
    public String frequencySort2(String s) {
        if (s == null || s.length() == 0) return s;
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char max = 0;
            for (char j = 0; j < 128; j++) {
                if (count[max] < count[j]) {
                    max = j;
                }
            }
            while (count[max] > 0) {
                sb.append(max);
                count[max]--;
            }
        }

        return sb.toString();
    }
}
