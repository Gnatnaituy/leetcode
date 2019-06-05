package java.classify.search.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 24ms 66.02%
     * 40.4MB 97.50%
     * 把res的声明放在combine()函数内需要33ms, 41.3MB
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || k > n) {
            return res;
        }

        backtrace(n, k, new ArrayList<>(), 1);

        return res;
    }

    private void backtrace(int n, int k, List<Integer> list, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 加上这个条件快了3ms
        if (start > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * BFS
     * 9ms 79.46%
     * 43MB 23.55%
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>());

        for (; k > 0; k--) {
            List<List<Integer>> next = new LinkedList<>();
            for (List<Integer> l : list) {
                int start = l.isEmpty() ? 1 : l.get(l.size() - 1) + 1;
                for (int j = start; j <= n - k  + 1; j++) {
                    l.add(j);
                    next.add(new LinkedList<>(l));
                    l.remove(l.size() - 1);
                }
            }
            list = next;
        }

        return list;
    }

    /**
     * DFS with pruning
     * 3ms 89.06%
     * 39.7MB 81.08%
     */
    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();

        backtrack(list, n, k, 1, new ArrayList<>());

        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, int start, List<Integer> temp) {
        if (k == 0) {
            list.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            backtrack(list, n, k - 1, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
