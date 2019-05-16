package classify.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * BFS
     * 8ms 61.81%
     * 46MB 32.49%
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Vertical Border
        for (int i = 0; i < row; i++) {
            pacificQueue.offer(new int[]{i ,0});
            atlanticQueue.offer(new int[]{i, col - 1});
            pacific[i][0] = true;
            atlantic[i][col - 1] = true;
        }

        // Horizontal Border
        for (int i = 0; i < col; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{row - 1, i});
            pacific[0][i] = true;
            atlantic[row - 1][i] = true;
        }

        bfs(matrix, pacificQueue, pacific);
        bfs(matrix, atlanticQueue, atlantic);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                // the next step coordinate {x, y}
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y]
                    || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    /**
     * DFS
     * 3ms 99.75%
     * 39.6MB 99.64%
     */
    public List<int[]> pacificAtlantic2(int[][] matrix) {
        List<int[]> res = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, pacific, i, 0, 0);
            dfs(matrix, atlantic, i, col - 1, 0);
        }

        for (int i = 0; i < col; i++) {
            dfs(matrix, pacific, 0, i, 0);
            dfs(matrix, atlantic, row - 1, i, 0);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y, int previous) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length
            || visited[x][y] || matrix[x][y] < previous) {
            return;
        }

        visited[x][y] = true;
        dfs(matrix, visited, x + 1, y, matrix[x][y]);
        dfs(matrix, visited, x - 1, y, matrix[x][y]);
        dfs(matrix, visited, x, y + 1, matrix[x][y]);
        dfs(matrix, visited, x, y - 1, matrix[x][y]);
    }
}
