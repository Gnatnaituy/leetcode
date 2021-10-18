package classify.linkedlist;

import tools.ListNode;

import java.util.Stack;

/**
 * @author yutiantang
 * @create 2021/10/18 15:38
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class PrintLinkedListReversely {

    /**
     * 2 ms     14.61%
     * 39.3MB   16.16%
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }

        return res;
    }

    /**
     * 0ms      100.00%
     * 39.1MB   37.60%
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int[] res = new int[size--];
        while (size >= 0) {
            res[size--] = head.val;
            head = head.next;
        }

        return res;
    }
}
