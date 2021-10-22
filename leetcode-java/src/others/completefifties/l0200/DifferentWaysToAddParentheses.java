package others.completefifties.l0200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DifferentWaysToAddParentheses {

    /**
     * 11ms 25.24%
     * 35.6MB 73.28%
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));
                for (int r1 : res1) {
                    for (int r2 : res2) {
                        switch (c) {
                            case '+':
                                res.add(r1 + r2);
                                break;
                            case '-':
                                res.add(r1 - r2);
                                break;
                            case '*':
                                res.add(r1 * r2);
                                break;
                        }
                    }
                }
            }
        }

        // input只剩下一个数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }

        // 排序 可有可无
        res.sort(Comparator.comparingInt(o -> o));

        return res;
    }
}
