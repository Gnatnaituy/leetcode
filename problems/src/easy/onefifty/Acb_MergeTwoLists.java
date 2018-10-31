package easy.onefifty;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Acb_MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1.val < l2.val) {
            while (l2.next != null) {
                ListNode tmpL2 = new ListNode(l2.val);
                tmpL2.next = l1.next.next;
                l1.next = tmpL2;
                l2 = l2.next;
            }
        }

        return l1;
    }
}
