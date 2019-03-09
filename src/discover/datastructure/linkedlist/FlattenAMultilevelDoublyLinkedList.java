package discover.datastructure.linkedlist;

import tools.MultipleDoublyListNode;

import java.util.ArrayList;
import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    /**
     * 脖子左歪45度，多级链表变成了二叉树，输出先序即可
     */
    public static MultipleDoublyListNode flatten(MultipleDoublyListNode head) {
        MultipleDoublyListNode dummy = new MultipleDoublyListNode(0,null,head,null);
        Stack<MultipleDoublyListNode> stack = new Stack<>();
        MultipleDoublyListNode cur = head;

        while(cur != null){
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child = null;
                cur.next.prev = cur;
            } else {
                if (cur.next == null && !stack.empty()) {
                    cur.next = stack.pop();
                    cur.next.prev = cur;
                }
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
