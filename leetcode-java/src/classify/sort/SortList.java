package classify.sort;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/4/14 20:22
 */
public class SortList {

    /**
     * 7ms      78.78%
     * 46.9MB   36.97%
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    private ListNode mergeSort(ListNode head) {
        // 如果没有结点或只有一个结点，无需排序，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找出中位点
        ListNode slow = head, fast = head.next.next, left, right;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 对左右两部分归并排序
        right = mergeSort(slow.next);
        slow.next = null;
        left = mergeSort(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left == null ? right : left;

        return dummyHead.next;
    }



    /**
     * 超出时间限制
     * 快速排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        return quickSort(dummyHead, null);
    }

    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end || head.next.next == end) {
            return head;
        }

        // 将小于划分点的值存储在临时链表中
        ListNode headOfSmallNodes = new ListNode(-1);
        // partitionNode为划分点，pnCur为链表指针，hosnCur为临时链表指针
        ListNode partitionNode = head.next, pnCur = partitionNode, hosnCur = headOfSmallNodes;
        // 将小于划分点的结点放到临时链表中
        while (pnCur.next != end) {
            if (pnCur.next.val < partitionNode.val) {
                hosnCur.next = pnCur.next;
                hosnCur = hosnCur.next;
                pnCur.next = pnCur.next.next;
            } else {
                pnCur = pnCur.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        hosnCur.next = head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next = headOfSmallNodes.next;
        quickSort(head, partitionNode);
        quickSort(partitionNode, end);

        // 返回结果时去除
        return head.next;
    }
}
