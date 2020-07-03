package completefifties.l0000;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    private List<String> ans = new ArrayList<>();

    /**
     * 4ms 85.07%
     * 一共就 3x3x3x3 = 81种情况, 直接用回溯法
     */
    public List<String> restoreIpAddresses(String s) {
        backtrack(0, 4, s.length(), 0, new int[4], new StringBuilder(s));

        return ans;
    }

    /**
     * @param k    填第k个格子
     * @param n    四个格子
     * @param len  给定IP地址的长度
     * @param cur  当前已填IP地址的长度
     * @param temp 储存一种分配情况, 可理解为四个格子, 每个格子填1或2或3，数组元素之和即为IP地址长度
     * @param s    给定IP地址
     */
    private void backtrack(int k, int n, int len, int cur, int[] temp, StringBuilder s) {
        // 填入的数字之和大于给定IP的长度，抛弃该数组
        if (cur > len)
            return;

        // k == n 表示已经填了四个数字
        if (k == n) {
            // 填了四个数字之后数组元素之和刚好等于给定IP地址长度
            if (cur == len) {
                StringBuilder ss = new StringBuilder();
                int now = 0;
                for (int i : temp) {
                    String sub = s.substring(now, now + i);
                    // 当某个格子中的数字不满足IP地址格式, 抛弃该数组
                    if (Integer.parseInt(sub) > 255 || sub.length() > 1 && sub.charAt(0) == '0')
                        return;
                    ss.append(sub).append(".");
                    now += i;
                }
                // 合法的IP地址, 并去除最后一个.
                ans.add(ss.substring(0, ss.length() - 1));
            }

            // 不论地址不合法或合法, 本轮结束
            return;
        }

        // 还未填满四个格子, 继续填
        for (int i = 1; i <= 3; i++) {
            temp[k] = i;
            backtrack(k + 1, n, len, cur + i, temp, s);
        }
    }
}
