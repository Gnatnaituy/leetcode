package huahua.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FloodFill {

    /**
     * 1ms 98.52%
     * 40.7MB 79.94%
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) return image;

        boolean[][] visited = new boolean[image.length][image[0].length];

        helper(image, visited, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    private void helper(int[][] image, boolean[][] visited, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || visited[sr][sc])
            return;

        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        helper(image, visited, sr + 1, sc, newColor, oldColor);
        helper(image, visited, sr - 1, sc, newColor, oldColor);
        helper(image, visited, sr, sc + 1, newColor, oldColor);
        helper(image, visited, sr, sc - 1, newColor, oldColor);
    }
}
