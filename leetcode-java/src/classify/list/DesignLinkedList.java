package classify.list;

/**
 * 707 Design LinkedList
 */

public class DesignLinkedList {

    /**
     * 10ms     70.05%
     * 41.6MB   15.96%
     */
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;

    public DesignLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        Node node = this.head;
        if (node == null) {
            return -1;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null) {
                return -1;
            }
        }

        return node.val;
    }

    public void addAtHead(int val) {
        this.head = new Node(val, this.head);
    }

    public void addAtTail(int val) {
        if (this.head == null) {
            this.head = new Node(val, null);
            return;
        }

        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val, null);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (this.head == null) {
            return;
        }

        Node temp = this.head;
        while (index > 1) {
            temp = temp.next;
            if (temp == null) {
                return;
            }
            index--;
        }

        temp.next = new Node(val, temp.next);
    }

    public void deleteAtIndex(int index) {
        if (this.head == null) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        Node cur = this.head;
        while (index > 1) {
            if (cur.next == null) {
                return;
            }
            cur = cur.next;
            index--;
        }

        cur.next = cur.next == null ? null : cur.next.next;
    }

    public static void main(String[] args) {
        DesignLinkedList list = new DesignLinkedList();
        list.addAtHead(3);
        list.deleteAtIndex(1);
    }
}