package huahua.search.combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 0ms 100.00%
     * 32.5MB 100.00%
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || k > n) return res;

        backtrace(new ArrayList<>(), k, n, 1);

        return res;
    }

    private void backtrace(List<Integer> list, int k, int n, int start) {
        if (n < 0) {
            return;
        }

        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 注意题目要求数字只能在1~9的范围内
        for (int i = start; i <= 9 && i <= n; i++) {
            list.add(i);
            backtrace(list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
