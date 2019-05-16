package classify.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    /**
     * 3ms 94.66%
     * 35MB 94.09%
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        // record the last index of the each char
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }

        return list;
    }
}
