package classify.list;

import tools.ListNode;

public class ReverseLinkedListII {

    /**
     * 1ms 96.74%
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mNode = new ListNode(0);
        mNode.next = head;
        ListNode curNode = head;
        int move = m;
        int init = m;

        while (init > 1) {
            mNode = mNode.next;
            curNode = curNode.next;
            init--;
        }

        while (move < n) {
            ListNode tempNode = curNode.next;
            curNode.next = tempNode.next;
            tempNode.next = mNode.next;
            mNode.next = tempNode;
            move++;
        }

        return m > 1 ? head : mNode.next;
    }

    /**
     * 0ms      100.00%
     * 39MB     65.20%
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy, pre = cur, swap;
        int step = 0;
        while (step < left) {
            pre = cur;
            cur = cur.next;
            step++;
        }
        while (step < right) {
            swap = cur.next;
            cur.next = swap.next;
            swap.next = pre.next;
            pre.next = swap;
            step++;
        }

        return dummy.next;
    }
}
