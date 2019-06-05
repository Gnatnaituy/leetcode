package java.contest;

import java.util.Arrays;

public class OneOneNine {
    
    public int[][] kClosest(int[][] points, int K) {
        int[] distances = new int[points.length];
    
        Arrays.sort(points, (o1, o2) -> {
            int x = o1[0] * o1[0] + o1[1] * o1[1];
            int y = o2[0] * o2[0] + o2[1] * o2[1];
            if (x > y)
                return -1;
            else
                return 1;
        });
        
        int[][] res = new int[K][];
        System.arraycopy(points, 0, res, 0, K);
        
        return res;
    }
    
    public int subarrayDivByK(int[] A, int K) {
        int res = 0;
    
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i; j++) {
                int sum = 0;
                for (int k = j; k < j + i + 1; k++) {
                    if (A[k] == 0 || A[k] % K == 0) continue;
                    else sum += A[k];
                }
                if (sum % K == 0) res++;
            }
        }
    
        return res;
    }
    
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int[] sumLeft = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sumLeft[i + 1] = sumLeft[i] + A[i];
        }
        
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if ((sumLeft[j] - sumLeft[i]) % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
