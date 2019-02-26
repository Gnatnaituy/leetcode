package others.easy.mtwenty;

/**
 * 949 Largest Time for Given Digits
 */

public class LargestTimeForGivenDigits {
    private int maxH = -1;
    private int maxM = -1;

    private String largestTimeFromDigits(int[] A) {
        boolean[] used = new boolean[4];
        
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                used[i] = true;
                used[j] = true;
                int d1 = 0, d2 = 0;
                for (int k = 0; k < 4; k++) {
                    if (!used[k]) {
                        d1 = A[k];
                        used[k] = true;
                        break;
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if (!used[k]) d2 = A[k];
                }
    
                int h1 = A[i] * 10 + A[j];
                int h2 = A[j] * 10 + A[i];
                int m1 = d1 * 10 + d2;
                int m2 = d2 * 10 + d1;
                
                change(h1, m1);
                change(h1, m2);
                change(h2, m1);
                change(h2, m2);
                
                used = new boolean[4];
            }
        }
        
        if (maxH != -1 && maxM != -1)
            return (maxH < 10 ? "0" + maxH : maxH) + ":" + (maxM < 10 ? "0" + maxM : maxM);
        else
            return "";
    }
    
    private void change(int H, int M) {
        if (H < 24 && M < 60 && H * 60 + M > maxH * 60 + maxM) {
            maxH = H;
            maxM = M;
        }
    }
    
    public static void main(String[] args) {
        int[] digits = {7, 2, 3, 7};
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(digits));
    }
}
