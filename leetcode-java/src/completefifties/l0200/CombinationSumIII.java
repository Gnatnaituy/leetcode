package completefifties.l0200;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    // Out of time
//    private HashSet<HashSet<Integer>> resHashSet;
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (k <= 0 || n <= 0)
//            return res;
//
//        resHashSet = new HashSet<>();
//        HashSet<Integer> list = new HashSet<>();
//        helper(k, n, list);
//
//        for (HashSet<Integer> hashSet : resHashSet) {
//            res.add(new ArrayList<>(hashSet));
//        }
//
//        return res;
//    }
//
//    private void helper(int k, int n, HashSet<Integer> list) {
//        if (n < 0) return;
//        if (k == 0 && n > 0) return;
//        if (k == 0 ) {
//            resHashSet.add(new HashSet<>(list));
//            return;
//        }
//
//        for (int i = 1; i <= 9; i++) {
//            if (!list.contains(i)) {
//                list.add(i);
//                helper(k - 1, n - i, list);
//                list.remove(i);
//            }
//        }
//    }


    /**
     * 2ms 63.18%
     * 32.9MB 63.90%
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combinationSum3(res, list, n, k, 1, 0, 0);

        return res;
    }

    private void combinationSum3(List<List<Integer>> res, List<Integer> list, int n, int k, int index, int size, int sum) {
        if (sum > n) return;

        if (size == k) {
            if (sum == n)
                res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (sum + i <= n) {
                list.add(i);
                combinationSum3(res, list, n, k, i + 1, size + 1, sum + i);
                list.remove(list.size() - 1);
            } else {
                return;
            }
        }
    }
}
