package classify.list;

import tools.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class IntersectionOfTwoLinkedList {

    /**
     * 1ms      100.00%
     * 41.2MB   53.42%
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode node) {
        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }

    /**
     * 10ms 12.48%
     */
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodes.contains(headB))
                return headB;
            else
                headB = headB.next;
        }
        return null;
    }

    /**
     * 5ms 14.76%
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode res = null;

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
            res = stackA.pop();
            stackB.pop();
        }

        return res;
    }

    /**
     * 1ms      99.52%
     * 44MB     27.65%
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;

        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
