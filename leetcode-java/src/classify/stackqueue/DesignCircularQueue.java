package classify.stackqueue;


/**
 * 设计你的循环队列实现。
 * 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 * - MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * - Front: 从队首获取元素。如果队列为空，返回 -1 。
 * - Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * - enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * - deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * - isEmpty(): 检查循环队列是否为空。
 * - isFull(): 检查循环队列是否已满。
 */
public class DesignCircularQueue {
    private int[] element;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public DesignCircularQueue(int k) {
        this.element = new int[k];
        this.capacity = k;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            // System.out.println("The queue is full!");
            return false;
        } else {
            element[rear] = value;
            size++;
            rear = (rear + capacity + 1) % capacity;
            return true;
        }
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            // System.out.println("The queue is empty!");
            return false;
        } else {
            front = (front + capacity + 1) % capacity;
            size--;
            return true;
        }
    }

    public int front() {
        if (this.isEmpty()) {
            // System.out.println("The queue is empty!");
            return -1;
        } else {
            return element[front];
        }
    }

    public int rear() {
        if (this.isEmpty()) {
            // System.out.println("The queue is empty!");
            return -1;
        } else {
            return element[(rear + capacity - 1) % capacity];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
