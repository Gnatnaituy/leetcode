package others.discover.datastructure.linkedlist;


import others.tools.RandomNode;

public class CopyListWithRandomPointer {

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        RandomNode l = head;
        while (l != null) {
            //每个原链表节点复制一个在后面
            RandomNode randomNode = new RandomNode(l.val,null,null);
            randomNode.next = l.next;
            l.next = randomNode;
            l = randomNode.next;
        }

        l = head;
        while (l != null && l.next != null) {
            //设置新链表的random节点,注意特殊情况：1.random为null,跳过该节点 2.next为null,跳出循环
            if(l.random != null) l.next.random = l.random.next;
            l = l.next.next;
        }

        l = head;
        RandomNode newHead = l.next;
        while (l != null) {
            //注意要把原链表和新的链表拆开，不要只拆新的链表
            RandomNode next = l.next;
            if(next != null) l.next = next.next;
            l = next;
        }
        
        return newHead;
    }
}
