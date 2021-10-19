package classify.string;

/**
 * @author yutiantang
 * @create 2021/10/19 11:21
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceBlankSpace {

    /**
     * 0ms      100.00%
     * 36.1MB   73.87%
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
