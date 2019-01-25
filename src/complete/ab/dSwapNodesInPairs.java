package complete.ab;

import tools.ListNode;

public class dSwapNodesInPairs {
    
    /**
     * 24. Swap Nodes in Pairs
     *
     * @param ListNode head 1->2->3->4->5
     * @return ListNode 2->1->4->3->5
     */
    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode cur = head, tempLeft = cur, tempRight;
        head = head.next;
        
        while (cur != null && cur.next != null) {
            tempRight = cur.next.next;
    
            tempLeft.next = cur.next;
            cur.next.next = cur;
            
            cur.next = tempRight;
    
            tempLeft = cur;
            cur = cur.next;
        }
        
        return head;
    }
}
