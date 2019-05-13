package classify.search.combination;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 24ms 66.02%
     * 40.4MB 97.50%
     * 把res的声明放在combine()函数内需要33ms, 41.3MB
     */
    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();

        if (k < 1 || k > n) return res;

        backtrace(n, k, new ArrayList<>(), 1);

        return res;
    }

    private void backtrace(int n, int k, List<Integer> list, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
