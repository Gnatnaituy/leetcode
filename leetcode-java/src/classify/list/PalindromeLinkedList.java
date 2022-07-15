package classify.list;

import tools.ListNode;

public class PalindromeLinkedList {

    /**
     * 判断一个链表是否为回文链表
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 拷贝原始链表
        ListNode origin = new ListNode(head.val);
        ListNode originCursor = origin;
        ListNode headCursor = head.next;
        while (headCursor != null) {
            originCursor.next = new ListNode(headCursor.val);
            originCursor = originCursor.next;
            headCursor = headCursor.next;
        }

        // 翻转链表
        ListNode cursor = head;
        while (cursor.next != null) {
            ListNode temp = cursor.next;
            cursor.next = temp.next;
            temp.next = head;
            head = temp;
        }

        // 比较反转后的链表是否和原始链表相同
        while (origin != null) {
            assert head != null;
            if (origin.val != head.val)
                return false;
            origin = origin.next;
            head = head.next;
        }

        return true;
    }

    /**
     * 3ms 98.69%
     * 57.7MB 39.12%
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int n = 0, i;
        ListNode pre = null, curr = null, curr2 = null, next = null;

        for (curr = head; curr != null; curr = curr.next) {
            n++;
        }

        int half = n / 2;
        for (curr = head, i = 0; i < half; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        curr = pre;
        curr2 = next;
        if (n % 2 != 0) {
            curr2 = curr2.next;
        }

        for (; curr != null; curr = curr.next, curr2 = curr2.next) {
            if (curr.val != curr2.val) {
                return false;
            }
        }

        return true;
    }

    /**
     * 3ms      98.69%
     * 57.9MB   28.76%
     */
    public boolean isPalindrome3(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode slowL = null, slowR = fast, tmpR;

        while (fast != null && fast.next != null) {
            tmpR = slowR;
            fast = fast.next.next;
            slowR = slowR.next;
            slow.next = slowL;
            slowL = slow;
            slow = tmpR;
        }

        if (fast != null) {
            slow.next = slowL;
        } else {
            slow = slowL;
        }

        while (slowR != null) {
            if (slowR.val != slow.val) {
                return false;
            }
            slowR = slowR.next;
            slow = slow.next;
        }

        return true;
    }
}
