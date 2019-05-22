package classify.graph;


import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    /**
     * 0ms 100.00%
     * 38.1MB 98.82%
     * DFS
     * Our goal is trying to use two colors to color the graph and see if there are
     * any adjacent nodes having the same color.
     * Initialize a color[] array for each node. Here are three states for colors[] array:
     *      0: Haven't been colored yet.
     *      1: Blue.
     *     -1: Red.
     *
     * For each node:
     *      If it hasn't been colored, use a color to color it. Then use
     *          the other color to color all its adjacent nodes (DFS).
     *      If it has been colored, check if the current color is the same as
     *          the color that is going to be used to color it.
     */
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) { // 处理图不是连通的情况
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1ms 81.05%
     * 42.4MB 66.22%
     * BFS
     */
    public boolean isBipartite2(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int next : graph[node]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[node];
                        queue.offer(next);
                    } else if (colors[next] != -colors[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
