package others.easy.ktwenty;

/**
 * 832 Flipping an Image
 */

public class FlippingAnImage {

    public int[][] flipAnImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = temp;
            }
            for (int k = 0; k < A[i].length; k++) {
                A[i][k] = A[i][k] == 0 ? 1 : 0;
            }
        }
        
        return A;
    }
}
