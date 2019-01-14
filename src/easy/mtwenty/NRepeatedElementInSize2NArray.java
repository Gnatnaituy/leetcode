package easy.mtwenty;

import java.util.Arrays;

/**
 * 961 N Repeated Element in Size 2N Array
 */

public class NRepeatedElementInSize2NArray {
    
    private int repeatedNTimes(int[] A) {
        int N = A.length / 2;
        int res;
        int times = 0;
        int cur = 0;
    
        Arrays.sort(A);
        res = A[cur];
        while (cur < A.length) {
            if (A[cur] == res) {
                times++;
                if (times == N)
                    return res;
            } else {
                res = A[cur];
                times = 1;
            }
            cur++;
        }
        
        return 0;
    }
}
