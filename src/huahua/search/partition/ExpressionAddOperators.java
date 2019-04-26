package huahua.search.partition;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        backTrack(res, num, 0, (long) target, 0, "");

        return res;
    }

    /**
     * When we use dfs to do this question, the most tricky part is that how to deal with multiplication.
     * For every addition and subtraction, we just directly adding or subtracting the new number.
     * However, for multiplication, we should multiply current number and previous number firstly,
     * and then add previous previous number.
     * So we can use a variable preNum to record every previous number in each recursion step.
     * If current recursive call is trying multiplication,
     * we should use previous calculation value subtract previous number,
     * and then adding multiplication result between previous number and current number.
     */
    private void backTrack(List<String> res, String num, int start, long target, long pre, String path) {
        if (start == num.length() && target == 0) {
            res.add(path);
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0')
                break;

            String temp = num.substring(start, i + 1);
            long cur = Long.parseLong(temp);

            if (start == 0) {
                backTrack(res, num, i + 1, target - cur, cur, path + cur);
            } else {
                backTrack(res, num, i + 1, target - cur, cur, path + "+" + cur);
                backTrack(res, num, i + 1, target + cur, -cur, path + "-" + cur);
                // trick part: to calculate multiplication
                // we should subtract previous number
                // and then add current multiplication result to the subtraction result
                backTrack(res, num, i + 1, target + pre - pre * cur, pre * cur, path + "*" + cur);
            }
        }
    }
}
