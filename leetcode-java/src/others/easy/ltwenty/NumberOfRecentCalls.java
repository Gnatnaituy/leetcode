package others.easy.ltwenty;

/**
 * 933 Number of Recent Calls
 */

public class NumberOfRecentCalls {
    private int[] queue;
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    public NumberOfRecentCalls() {
        queue = new int[10000];
    }
    
    public int ping(int t) {
        queue[rear++] = t;
        size++;
        while (true) {
            if (t - queue[front] > 3000) {
                front++;
                size--;
            } else {
                break;
            }
        }
        
        return size;
    }
}
