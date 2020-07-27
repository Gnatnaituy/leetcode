package classify.graph;

public class RedundantConnection {

    /**
     * 1ms 91.80%
     * 40.4MB 65.33%
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int f = edge[0];
            int t = edge[1];
            if (find(parent, f) == find(parent, t)) {
                return edge;
            } else {
                parent[find(parent, f)] = parent[t];
            }
        }

        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }

        return parent[f];
    }
}