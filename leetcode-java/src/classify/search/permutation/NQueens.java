package classify.search.permutation;

import java.util.LinkedList;
import java.util.List;

public class NQueens {
    private List<List<String>> res = new LinkedList<>();
    private StringBuilder colString = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            colString.append(".");
        }

        boolean[] rowV = new boolean[n];
        boolean[] colV = new boolean[n];
        boolean[] negV = new boolean[2 * n - 1];
        boolean[] posV = new boolean[2 * n - 1];

        dfs(n, rowV, colV, negV, posV, 0, new LinkedList<>());

        return res;
    }

    private void dfs(int n, boolean[] rowV, boolean[] colV, boolean[] negV, boolean[] posV, int row, List<String> list) {
        if (row == n) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int neg = n - row - 1 + col;
            int pos = row + col;
            
            if (!rowV[row] && !colV[col] && !negV[neg] && !posV[pos]) {
                rowV[row] = true;
                colV[col] = true;
                negV[neg] = true;
                posV[pos] = true;
                list.add(new StringBuilder(colString).replace(col, col + 1, "Q").toString());
                
                dfs(n, rowV, colV, negV, posV, row + 1, list);

                rowV[row] = false;
                colV[col] = false;
                negV[neg] = false;
                posV[pos] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
