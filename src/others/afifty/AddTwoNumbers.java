package others.afifty;

import others.tools.ListNode;

/**
 * 2 Add Two Numbers
 */

public class AddTwoNumbers {

    /**
     * 54ms
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int add = val1 + val2 + carry;
            
            cur.next = new ListNode(add % 10);
            carry = add / 10;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if (carry == 1) cur.next = new ListNode(carry);
        
        return res.next;
    }

    /**
     * 25ms
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode runner = preHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            runner.next = new ListNode(carry % 10);
            runner = runner.next;
            carry /= 10;
        }

        return preHead.next;
    }
}
