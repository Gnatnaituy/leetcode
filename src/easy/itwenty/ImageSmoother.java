package easy.itwenty;

/**
 * 661 Image Smoother
 *
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of
 * each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 *
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */

public class ImageSmoother {
    public int[][] imageSmother(int[][] M) {
        int a = M.length;
        int b = M[0].length;
        int[][] x = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                x[i][j] = avg(i, j, a, b, M);
            }
        }
        return x;
    }

    private int avg(int i, int j, int a, int b, int[][] M) {
        int cur = M[i][j];
        int u = i - 1;
        int d = i + 1;
        int l = j - 1;
        int r = j + 1;

        int c = 1;
        if (u >= 0 && u < a && l >= 0 && l < b) {
            c++;
            cur += M[u][l];
        }
        if (u >= 0 && u < a) {
            c++;
            cur += M[u][j];
        }
        if (u >= 0 && u < a && r < b) {
            c++;
            cur += M[u][r];
        }
        if (r < b) {
            c++;
            cur += M[i][r];
        }
        if (r < b && d < a) {
            c++;
            cur += M[d][r];
        }
        if (d < a) {
            c++;
            cur += M[d][j];
        }
        if (d < a && l >= 0 && l < b) {
            c++;
            cur += M[d][l];
        }
        if (l >= 0 && l < b) {
            c++;
            cur += M[i][l];
        }
        return cur / c;
    }
}
