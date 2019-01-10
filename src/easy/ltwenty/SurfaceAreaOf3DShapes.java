package easy.ltwenty;

/**
 * 892 Surface Area of 3D Shapes
 */

public class SurfaceAreaOf3DShapes {
    
    private int surfaceArea(int[][] grid) {
        int res = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res += grid[i][j] * 4 + 2;
                    if (i > 0) res -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                    if (j > 0) res -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
                }
            }
        }
        
        return res;
    }
}
