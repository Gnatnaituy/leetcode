package huahua.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    /**
     * 96ms 29.97%
     * 52.3MB 28.39%
     */
    public int largestIsland(int[][] grid) {
        int max = -1, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(i, j, grid, new boolean[m][n]));
                    grid[i][j] = 0;
                }
            }
        }

        return max == -1 ? grid.length * grid[0].length : max;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] != 1 || visited[i][j])
            return 0;

        visited[i][j] = true;

        return 1 + dfs(i + 1, j, grid, visited)
                + dfs(i - 1, j, grid, visited)
                + dfs(i, j + 1, grid, visited)
                + dfs(i, j - 1, grid, visited);
    }

    /**
     * 11ms
     */
    public int largestIsland2(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>(); //Key: colorIsland, Val: size of island painted of that colorIsland
        map.put(0, 0); //We won't colorIsland island 0, hence make its size 0, we will use this value later
        int len = grid.length;
        int colorIndex = 2; //0 and 1 is already used in grid, hence we start colorIndex from 2
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    int size = colorIsland(grid, i, j, colorIndex);
                    map.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }

        // Check if the size is of 1 in the map of index 2.
        //If there is no island 0 from grid, res should be the size of islands of first colorIsland
        //If there is no island 1 from grid, res should be 0
        int res = map.getOrDefault(2, 0);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 0) {
                    //We use a set to avoid repeatly adding islands with the same colorIsland
                    Set<Integer> set = new HashSet<>();
                    //If current island is at the boundary, we add 0 to the set, whose value is 0 in the map
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < len - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < len - 1 ? grid[i][j + 1] : 0);

                    int tempSize = 1; //We need to count current island as well, hence we init newSize with 1
                    for (int color : set) tempSize += map.get(color);
                    res = Math.max(res, tempSize);
                }
            }
        }

        return res;
    }

    //Helper method to colorIsland current island and all its connected neighbors
    //Return the size of all painted islands at the end
    private int colorIsland(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = color;

        return 1 +
                colorIsland(grid, i + 1, j, color) +
                colorIsland(grid, i - 1, j, color) +
                colorIsland(grid, i, j + 1, color) +
                colorIsland(grid, i, j - 1, color);

    }
}
