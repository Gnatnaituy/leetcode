package java.completefifties.l0000;

import java.others.tools.ListNode;

public class MergeKSortedLists {
    
    /**
     * 23. Merge K Sorted Lists
     *
     * @param ListNode[] lists
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
}
