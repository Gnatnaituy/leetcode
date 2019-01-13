package easy.mtwenty;

/**
 * 944 Delete Columns to Make Sorted
 */

public class DeleteColumnsToMakeSorted {

    private int minDeletionSize(String[] A) {
        int strlen = A[0].length();
        int min = 0;
        
        for (int i = 0; i < strlen; i++){
            for (int j = 0; j < A.length - 1; j++){
                if (A[j].charAt(i) > A[j + 1].charAt(i)){
                    min++;
                    break;
                }
            }
        }
        
        return min;
    }
}
