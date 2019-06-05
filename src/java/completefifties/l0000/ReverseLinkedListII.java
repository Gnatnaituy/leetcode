package java.completefifties.l0000;

import java.others.tools.ListNode;

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
}
