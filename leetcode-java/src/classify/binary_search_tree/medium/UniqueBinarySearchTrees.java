package classify.binary_search_tree.medium;

public class UniqueBinarySearchTrees {

    /**
     * 0ms      100.00%
     * 38.3MB   43.78%
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
