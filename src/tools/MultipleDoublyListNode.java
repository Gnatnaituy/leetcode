package tools;

public class MultipleDoublyListNode {
    public int val;
    public MultipleDoublyListNode prev;
    public MultipleDoublyListNode next;
    public MultipleDoublyListNode child;

    public MultipleDoublyListNode() {}

    public MultipleDoublyListNode(int val,
                                  MultipleDoublyListNode prev,
                                  MultipleDoublyListNode next,
                                  MultipleDoublyListNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
