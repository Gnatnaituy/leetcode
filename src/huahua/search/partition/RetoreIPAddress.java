package huahua.search.partition;

import java.util.ArrayList;
import java.util.List;

public class RetoreIPAddress {
    private List<String> res = new ArrayList<>();

    /**
     * 2ms 85.77%
     * 37.3MB 25.19%
     */
    public List<String> restoreIpAddresses(String s) {
        backtrace(s, new ArrayList<>(), 4, 0);

        return res;
    }

    private void backtrace(String s, List<Integer> list, int segments, int start) {
        if (segments < 0) return;
        if (segments == 0 && start < s.length()) return;
        if (segments == 0 && start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
            if (i - start > 1 && s.charAt(start) == '0')
                return;

            int val = Integer.parseInt(s.substring(start, i));
            if (0 <= val && val <= 255) {
                list.add(val);
                backtrace(s, list, segments - 1, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
