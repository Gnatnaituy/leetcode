package completefifties.l0000;

import java.util.*;

public class Combinations {

    /**
     * 超出时间限制
     */
    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        Set<Set<Integer>> set = new HashSet<>();
        Set<Set<Integer>> newSet;
        Set<Integer> newInner;

        for (int i = 1; i <= n; i++) {
            Set<Integer> inner = new HashSet<>();
            inner.add(i);
            set.add(inner);
        }

        for (int i = 2; i <= k; i++) {
            newSet = new HashSet<>();
            for (Set<Integer> inner : set) {
                for (int j = 1; j <= n; j++) {
                    newInner = new HashSet<>(inner);
                    newInner.add(j);
                    newSet.add(newInner);
                }
            }
            set = new HashSet<>(newSet);
        }

        for (Set<Integer> inner : set) {
            if (inner.size() == k)
                res.add(new ArrayList<>(inner));
        }

        return res;
    }

    /**
     * 16ms 72.18%
     */
    public List<List<Integer>> combine2(int n, int k) {
        if (k > n || k < 0) {
            return new ArrayList<>();
        }

        if (k == 0) {
            List<Integer> out = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            res.add(out);
            return res;
        }

        // The combinations that include n
        List<List<Integer>> res = combine(n - 1, k - 1);
        for (List<Integer> a : res) {
            a.add(n);
        }

        // The combination that didn't include n
        res.addAll(combine(n - 1, k));

        return res;
    }

    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || k > n)
            return res;
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    /**
     * 这里i <= n 换成 i <= (n-(k-cur.size())) + 1 避免不必要的搜索
     * 例如:  n=4, k=3时
     * *       1         2     i <= (4 - (3 - 0)) + 1 = 2
     * *     / |        /
     * *    2  3       3       i <= (4 - (3 - 1)) + 1 = 3
     * *   / \  \     /
     * *  3  4   4   4         i <= (4 - (3 - 2)) + 1 = 4
     */
    private void backtrack(List<List<Integer>> res, List<Integer> cur, int n, int k, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= (n - (k - cur.size())) + 1; i++) {
            cur.add(i);
            backtrack(res, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
