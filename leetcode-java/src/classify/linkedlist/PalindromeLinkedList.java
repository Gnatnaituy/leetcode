package classify.linkedlist;

import tools.ListNode;

import java.util.ArrayList;

public class PalindromeLinkedList {

    /**
     * 3ms 21.35%
     * 38.8MB 99.96%
     */
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 0ms
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;

        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            ListNode next = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = next;
        }

        if (p2 != null) {
            p1 = p1.next;
        }

        while (pre != null) {
            if (pre.val != p1.val) {
                return false;
            }
            p1 = p1.next;
            pre = pre.next;
        }

        return true;
    }
}
