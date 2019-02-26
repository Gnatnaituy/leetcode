package others.easy.ltwenty;

/**
 * 941 Valid Mountain Array
 */

public class ValidMountainArray {

    private boolean validMountainArray(int[] A) {
        // 8ms 45.38%
//        if (A.length < 3)
//            return false;
//        else {
//            for (int i = 0; i < A.length - 2; i++) {
//                if (A[i] < A[i + 1]) {
//                    if (i == A.length - 2)
//                        return false;
//                } else {
//                    if (i == 0)
//                        return false;
//                    for (int j = i; j < A.length - 2; j++) {
//                        if (A[j] <= A[j + 1])
//                            return false;
//                    }
//                    break;
//                }
//            }
//        }
//
//        return true;
    
        if(A.length < 3) return false;
        int i = 1;
        
        while(i < A.length){
            if(A[i - 1] < A[i]){
                ++i;
            } else if (A[i - 1] == A[i])
                return false;
            else break;
        }
        
        if(i == A.length || i == 1)
            return false;
        
        while(i < A.length){
            if(A[i - 1] > A[i]){
                ++i;
            } else if (A[i - 1] == A[i])
                return false;
            else break;
        }
        
        return i == A.length;
    }
}
