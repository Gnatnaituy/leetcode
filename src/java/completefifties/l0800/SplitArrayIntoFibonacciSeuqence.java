package java.completefifties.l0800;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSeuqence {

    /**
     * 12ms 74.71%
     * 35.5MB 85.71%
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrace(S, res, new ArrayList<>(), 0);

        return res;
    }

    private void backtrace(String s, List<Integer> res, List<Integer> temp, int pos) {
        if (res.size() != 0) return;

        if (pos == s.length() && temp.size() >= 3) {
            res.addAll(temp);
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            // 数字除非为0, 否则不能以0开头
            if (s.charAt(pos) == '0' && i > pos) {
                break;
            }
            // 每个数字不超过2^32 - 1
            long num = Long.parseLong(s.substring(pos, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = temp.size();
            // 提前终止回溯的条件
            if (size >= 2 && num > temp.get(size - 1) + temp.get(size - 2)) {
                break;
            } else {
                if (size < 2 || (num == temp.get(size - 1) + temp.get(size - 2))) {
                    temp.add((int) num);
                    backtrace(s, res, temp, i + 1);
                    temp.remove(size);
                }
            }
        }
    }
}
