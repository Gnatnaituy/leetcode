package easy.mtwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 949 Largest Time for Given Digits
 */

public class LargestTimeForGivenDigits {

    private String largestTimeFromDigits(int[] A) {
        StringBuilder res = new StringBuilder();
        boolean[] used = new boolean[4];
        int[] resDigit = new int[4];
        
        Arrays.sort(A);
        if (A[0] > 2 || A[1] > 5) return "";
        
        for (int i = 3; i >= 0; i--) {
            if (A[i] < 3) {
                resDigit[0] = A[i];
                used[i] = true;
                break;
            }
        }
        
        for (int i = 3; i >= 0; i--) {
            if (resDigit[0] == 2) {
                if (A[i] < 4 && !used[i]) {
                    resDigit[1] = A[i];
                    used[i] = true;
                    break;
                }
            } else {
                if (!used[i])
                    resDigit[1] = A[i];
                used[i] = true;
                break;
            }
        }
        
        for (int i = 3; i >= 0; i--) {
            if (A[i] < 6 && !used[i]) {
                resDigit[2] = A[i];
                used[i] = true;
                break;
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (!used[i])
                resDigit[3] = A[i];
        }
        
        for (int i = 0; i < 4; i++) {
            if (i == 2) res.append(":");
            res.append(resDigit[i]);
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4};
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(digits));
    }
}
