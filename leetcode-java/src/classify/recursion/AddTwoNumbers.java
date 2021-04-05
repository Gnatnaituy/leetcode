package classify.recursion;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/4/5 12:26
 */
public class AddTwoNumbers {

    private int carry = 0;

    /**
     * 2ms      100.00%
     * 39MB     18.56%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        carry = sum / 10;
        ListNode node = new ListNode(sum % 10);

        if (carry != 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
            node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        }

        return node;
    }
}
