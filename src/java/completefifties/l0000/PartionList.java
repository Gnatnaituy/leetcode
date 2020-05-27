package java.completefifties.l0000;

import java.tools.ListNode;

public class PartionList {

    /**
     * 2ms 17.65%
     */
    public ListNode partion(ListNode head, int x) {
        ListNode biggerHead = new ListNode(0);
        ListNode smallerHead = new ListNode(0);
        ListNode biggerCur = biggerHead;
        ListNode smallerCur = smallerHead;

        while (head != null) {
            if (head.val < x) {
                smallerCur.next = new ListNode(head.val);
                smallerCur = smallerCur.next;
            } else {
                biggerCur.next = new ListNode(head.val);
                biggerCur = biggerCur.next;
            }
            head = head.next;
        }

        smallerCur.next = biggerHead.next;

        return smallerHead.next;
    }
}
