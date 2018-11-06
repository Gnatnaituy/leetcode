package easy.onetwenty;


/**
 * 21 Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else
            return l1.val < l2.val ? innerMergeTwoLists(l1, l2) : innerMergeTwoLists(l2, l1);
    }

    private static ListNode innerMergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cursor = l1;
        while (l2 != null && cursor.next != null) {
            if (l2.val < cursor.next.val) {
                ListNode temp = new ListNode(l2.val);
                temp.next = cursor.next;
                cursor = cursor.next = temp;
                l2 = l2.next;
            } else {
                cursor = cursor.next;
            }
        }
        if (l2 != null)
            cursor.next = l2;

        return l1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
//        ListNode node24 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node21.next = node22;
        node22.next = node23;
//        node23.next = node24;

        ListNode result = mergeTwoLists(node1, node21);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}
