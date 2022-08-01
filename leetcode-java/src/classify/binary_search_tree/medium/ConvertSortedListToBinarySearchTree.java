package classify.binary_search_tree.medium;

import tools.ListNode;
import tools.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    
    /**
     * 0ms      100.00%
     * 41.9MB   99.37%
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slowPre = null, slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        if (slowPre != null) slowPre.next = null;
        node.right = sortedListToBST(slow.next);
        if (slow != head) {
            node.left = sortedListToBST(head);
        }

        return node;
    }
}
