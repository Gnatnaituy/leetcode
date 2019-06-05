package java.others.discover.algorithm.elementary.list;

import java.others.tools.ListNode;

public class PalindromeLinkedList {

    /**
     * 判断一个链表是否为回文链表
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        /*
        3ms 46.71%
        三个月前写的
         */
        if (head == null || head.next == null) return true;

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
     * 方案1：
     * 拷贝原始的列表
     * 反转原始列表
     * 然后从头到尾遍历两个链表，每个元素都相同就是回文，否则不是
     *
     * 方案2：
     * 先遍历一遍，记录总个数
     * 然后反转前半段
     * 最后比较前遍历前半段和后半段
     * @author tiger.xiong
     *
     */
    public boolean isPalindrome2(ListNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        int n=0,i;
        ListNode pre=null,curr=null,curr2=null,next=null;

        for (curr=head;curr!=null;curr=curr.next) {
            n++;
        }

        int half = n/2;
        for (curr=head,i=0;i<half;i++) {
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }

        curr=pre;
        curr2=next;
        if (n%2!=0) {
            curr2=curr2.next;
        }

        for (;curr!=null;curr=curr.next,curr2=curr2.next) {
            if (curr.val!=curr2.val) {
                return false;
            }
        }
        return true;
    }
}
