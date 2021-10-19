package classify.linkedlist;

import tools.RandomNode;

/**
 * @author yutiantang
 * @create 2021/10/18 16:29
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyRandomList {

    /**
     * 0ms      100.00%
     * 37.6MB   97.26%
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        // 复制一个Node到原有Node的后面 如1->2->3->null变为1->1'->2->2'->3->3'->null
        for (RandomNode node = head, copy; node != null; node = node.next.next) {
            copy = new RandomNode(node.val, null, null);
            copy.next = node.next;
            node.next = copy;
        }

        // 复制Random节点
        for (RandomNode node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        // 拷贝节点和源节点分离 1->1'->2->2'->3->3'->null变为1->2->3->null和1'->2'->3'->null
        RandomNode copyHead = head.next;
        for (RandomNode node = head, temp; node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return copyHead;
    }
}
