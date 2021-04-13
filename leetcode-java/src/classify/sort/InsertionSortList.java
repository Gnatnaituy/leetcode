package classify.sort;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/4/13 20:30
 */
public class InsertionSortList {

    /**
     * 3ms      98.18%
     * 37.9MB   93.73%
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curPre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < curPre.val) {
                ListNode dummyCur = dummy.next;
                ListNode dummyCurPre = dummy;
                while (dummyCur.val < cur.val) {
                    dummyCur = dummyCur.next;
                    dummyCurPre = dummyCurPre.next;
                }
                curPre.next = cur.next;
                cur.next = dummyCur;
                dummyCurPre.next = cur;
                cur = curPre.next;
            } else {
                cur = cur.next;
                curPre = curPre.next;
            }
        }

        return dummy.next;
    }
}

