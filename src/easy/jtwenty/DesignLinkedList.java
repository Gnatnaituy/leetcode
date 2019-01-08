package easy.jtwenty;

/**
 * 707 Design LinkedList
 */

public class DesignLinkedList {
    Node head;

    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

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
        Node node = new Node(val, this.head);
        this.head = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val, null);
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addAtIndex(int index, int val) {
        Node temp = this.head;
        if (temp == null) {
            if(index == 0) {
                addAtHead(val);
                return;
            } else {
                return;
            }
        }
        for (int i = 1; i < index; i++) {
            temp = temp.next;
            if (temp == null) {
                return;
            }
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    public void deleteAtIndex(int index) {
        Node temp = this.head;
        Node previous = null;
        if (temp == null) {
                return;
        }
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                previous = temp;
            }
            temp = temp.next;
            if (temp == null) {
                return;
            }
        }
        previous.next = temp.next;
    }
}