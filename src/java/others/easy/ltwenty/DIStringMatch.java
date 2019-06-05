package java.others.easy.ltwenty;

import java.util.LinkedList;

/**
 * 942 DI String Match
 */

public class DIStringMatch {

    private int[] diStringMatch(String S) {
        // 19ms 5.97%...
        char[] s = S.toCharArray();
        LinkedList<Integer> queue = new LinkedList<>();
        int length = s.length + 1;
        int[] res = new int[length];

        queue.add(0);
        int countD = 0, countI = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'I') {
                countI++;
                queue.addLast(countI);
            } else {
                countD++;
                queue.add(i, length - countD);
            }
        }

        for (int i = 0; i < length; i++) {
            res[i] = queue.pollFirst();
        }

        return res;
    }
}
