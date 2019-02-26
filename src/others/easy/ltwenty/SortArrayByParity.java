package others.easy.ltwenty;

/**
 * 905 Sort Array by Parity
 */

public class SortArrayByParity {

    private int[] sortArrayByParity(int[] A) {
        int head = 0, tail = A.length - 1;
        
        while (head < tail) {
            if (A[head] % 2 == 1) {
                while (A[tail] % 2 == 1 && tail >= head)
                    tail--;
                if (head < tail) {
                    int temp = A[head];
                    A[head] = A[tail];
                    A[tail] = temp;
                } else return A;
            } else head++;
        }
        
        return A;
    }
}
