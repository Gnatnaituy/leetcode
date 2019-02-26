package others.afifty;

import tools.ListNode;

/**
 * 2 Add Two Numbers
 */

public class AddTwoNumbers {
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode((l1.val + l2.val) % 10);
        ListNode cur = res;
        // judge carry or not
        int carry = l1.val + l2.val > 9 ? 1 : 0;
        l1 = l1.next; l2 = l2.next;
        
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int add = val1 + val2 + carry;
            
            cur.next = new ListNode(add % 10);
            carry = add > 10 ? 1 : 0;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if (carry == 1) cur.next = new ListNode(carry);
        
        return res;
    }
}
