package classify.dp.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * O(n^2)   2ms      22.94%
     * O(n^2)   41.4MB   58.19%
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);

        return res;
    }

    private void generate(List<String> res, String ans, int countLeft, int countRight, int n) {
        if (countLeft > n || countRight > n) {
            return;
        }
        if (countLeft == n && countRight == n) {
            res.add(ans);
        }
        if (countLeft >= countRight) {
            generate(res, ans + "(", countLeft + 1, countRight, n);
            generate(res, ans + ")", countLeft, countRight + 1, n);
        }
    }
}
