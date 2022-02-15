package classify.list;

import tools.ListNode;

/**
 * 203 Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

public class RemoveLinkedListElements {

    /**
     * 递归
     * 6ms 65.18%
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }

    /**
     * 不添加虚拟节点方式
     * 6ms 65.18%
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head.val == val ? head.next : head;
    }

    /**
     * 添加虚拟节点方式
     * 0ms      100.00%
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode(), slow = dummy, fast = head;
        dummy.next = head;
        while (fast != null) {
            if (fast.val != val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;

        return dummy.next;
    }
}
