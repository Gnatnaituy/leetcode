package java.classify.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    private static final int UNKNOWN = 0;
    private static final int UNSAFE = 1;
    private static final int SAFE = 2;

    /**
     * 5ms 100.00%
     * 63.9MB 91.51%
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] states = new int[N];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (dfs(graph, i, states))
                res.add(i);
        }

        return res;
    }

    private boolean dfs(int[][] graph, int index, int[] states) {
        // already visited
        if (states[index] != UNKNOWN)
            return states[index] == SAFE;

        states[index] = UNSAFE;
        for (int node : graph[index]) {
            // has cycle
            if (!dfs(graph, node, states))
                return false;
        }

        // no cycle
        states[index] = SAFE;

        return true;
    }
}
