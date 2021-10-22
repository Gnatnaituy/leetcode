package others.completefifties.l0000;

import java.util.*;

public class Combinations {

    /**
     * 超出时间限制
     */
    public List<List<Integer>> combine(int n, int k) {
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
     *
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

        List<List<Integer>> res = combine(n - 1, k - 1);
        for (List<Integer> a : res)
            a.add(n);

        res.addAll(combine(n - 1, k));

        return res;
    }
}
