package java.classify.search.permutation;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSqurefulArrays {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms 99.19%
     * 35.5MB 85.60%
     */
    public int numSquarefulPerms(int[] A) {
        backtrace(new ArrayList<>(), A, new boolean[A.length]);

        return res.size();
    }

    private void backtrace(List<Integer> list, int[] A, boolean[] visited) {
        if (list.size() == A.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (visited[i])
                continue;

            if (i > 0 && A[i] == A[i - 1] && !visited[i - 1])
                continue;

            if (list.size() == 0) {
                list.add(A[i]);
                visited[i] = true;
                backtrace(list, A, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            } else {
                if (isPerfectSquare(list.get(list.size() - 1) + A[i])) {
                    list.add(A[i]);
                    visited[i] = true;
                    backtrace(list, A, visited);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean isPerfectSquare(int num) {
        return Math.pow(((int) Math.sqrt(num)), 2) == num;
    }
}
