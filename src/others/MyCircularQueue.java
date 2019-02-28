package others;

class MyCircularQueue {

    private int[] elementData;
    private int capacity;
    private int front = 0;
    private int rear = 0;

    /** Initialize your data structure here. Set the size of the queueandbfs to be k. */
    public MyCircularQueue(int k) {
        elementData = new int[k];
        capacity = k;
        front = -1;
        rear = -1;
    }
    
    /** Insert an element into the circular queueandbfs. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        elementData[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
            return true;
        }
        front = (front + 1) % capacity;
        return true;
    }
    
    /** Get the front item from the queueandbfs. */
    public int Front() {
        if (!isEmpty()) {
            return elementData[front];
        } else {
            return -1;
        }
    }
    
    /** Get the last item from the queueandbfs. */
    public int Rear() {
        if (!isEmpty()) {
            return elementData[rear];
        } else {
            return -1;
        }
        
    }
    
    /** Checks whether the circular queueandbfs is empty or not. */
    public boolean isEmpty() {
        return front == -1;
        
    }
    
    /** Checks whether the circular queueandbfs is full or not. */
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */