package others;

import tools.ListNode;

import java.util.ArrayList;
import java.util.List;

public class OneThreeZero {

    public List<Boolean> prefixDivBy5(int[] A) {
        int last = 0;
        List<Boolean> res = new ArrayList<>();

        for (int value : A) {
            last = (last * 2 + value) % 10;
            res.add(last == 5 || last == 0);
        }

        return res;
    }


    public String baseNeg2(int N) {
        return "";
    }


    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();

        while (head != null) {
            ListNode node = head;
            while (node.val <= head.val) {
                node = node.next;
                if (node == null) break;
            }

            if (node == null) {
                res.add(0);
            } else {
                res.add(node.val);
            }
            head = head.next;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
