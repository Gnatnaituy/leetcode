package complete.ad;

import tools.ListNode;

public class aRotateList {

    /**
     * 61. Rotate List
     */
    public ListNode rotateRight(ListNode head, int k) {
        // if (k == 0) {
        //     return head;
        // } else {
        //     ListNode cur = head;
        //     while (cur.next.next != null) cur = cur.next;
        //     cur.next.next = head;
        //     head = cur.next;
        //     cur.next = null;
        //     k--;
        //     return rotateRight(head, k);
        // }

        if (head == null)
            return null;
        ListNode left = head;
        ListNode right = head;
        ListNode res;
        int idx = 0;
        while (right != null) {
            idx++;
            right = right.next;
        }
        right = head;
        k = k  % idx;
        idx = 0;
        while (idx != k) {
            if (right == null)
                right = head;            
            idx++;
            right = right.next;            
        }
        if (right == null)
            right = head;        
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        right.next = head;
        res = left.next;
        left.next = null;
        return res;
    }
}