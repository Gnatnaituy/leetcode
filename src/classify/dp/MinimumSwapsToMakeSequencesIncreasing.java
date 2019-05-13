package classify.dp;

import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] notSwap = new int[n];
        //notSwap[i] -> min swaps to make {A[0]~A[i]} and {B[0]~B[i]} without swapping A[i] and B[i]
        int[] swap = new int[n];
        //swap[i] -> min swaps to make {A[0]~A[i]} and {B[0]~B[i]} with swapping A[i] and B[i]
        Arrays.fill(notSwap, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        notSwap[0] = 0;
        swap[0] = 1;

        for (int i = 1; i < n; i++) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1; //swap both A[i - 1], B[i - 1] & A[i], B[i]
                notSwap[i] = notSwap[i - 1]; //don't swap both A[i - 1], B[i - 1] & A[i], B[i]
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                //if we swap A[i],B[i], we don't need to swap A[i - 1],B[i - 1]
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
                //notSwap[i - 1] + 1 because we didn't swap A[i - 1] & B[i - 1] and +1 for current swap
                //if we swap A[i - 1],B[i - 1], we don't need to swap A[i],B[i]
                notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
            }
        }

        return Math.min(swap[n - 1], notSwap[n - 1]);
    }
}
