package classify.list;

import tools.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeKSortedLists {

    /**
     * 100ms    25.90%
     * 40.2MB   33.39%
     *
     * @param lists
     * @return ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = lists.length - 1; i > 0; i--) {
            lists[i - 1] = mergeTwoLists(lists[i], lists[i - 1]);
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode node = root;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        node.next = list1 == null ? list2 : list1;

        return root.next;
    }

    /**
     * 10ms     29.52%
     * 39.9MB   83.22%
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                numCount.put(listNode.val, numCount.getOrDefault(listNode.val, 0) + 1);
                listNode = listNode.next;
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        List<Map.Entry<Integer, Integer>> entries = numCount.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .collect(Collectors.toList());


        for (Map.Entry<Integer, Integer> entry : entries) {
            int num = entry.getKey();
            int times = entry.getValue();
            while (times-- > 0) {
                cur.next = new ListNode(num);
                cur = cur.next;
            }
        }

        return res.next;
    }
}
