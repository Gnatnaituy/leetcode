package classify.list;

import tools.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {

    /**
     * 6ms 76.43%
     * 44.2MB 74.25%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int carry = 0;
        ListNode res = new ListNode(1);

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = res.next;
            res.next = node;
            carry = sum / 10;
        }

        return res.next;
    }
}
