package others.completefifties.l0000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    
    /**
     * 40. Combination Sum II
     */
    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> out = new ArrayList<Integer>();
        helper(candidates, target, 0, out, res);
        return res;
    }
    
    private static void helper(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<Integer>(out));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > target){
                break;
            }
            if(i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            out.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, out, res);
            out.remove(out.size() - 1);
        }
    }
}
