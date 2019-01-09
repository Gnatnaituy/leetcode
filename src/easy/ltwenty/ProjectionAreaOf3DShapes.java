package easy.ltwenty;

/**
 * 883 Projection Area of 3D Shapes
 */

public class ProjectionAreaOf3DShapes {

    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int t = 0, s = 0, f = 0, len = grid.length;
        
        for (int i = 0; i < len; i++) {
            int sMax =  0, fMax = 0;
            for (int j = 0; j < len; j++) {
                if (grid[i][j] != 0) t++;
                if (grid[i][j] > sMax) sMax = grid[i][j];
            }
            s += sMax;
            for (int[] aGrid : grid) {
                if (aGrid[i] > fMax) fMax = aGrid[i];
            }
            f += fMax;
        }
        
        return t + s + f;
    }
}
