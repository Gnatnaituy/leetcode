package others.completefifties.l0000;

import java.util.LinkedList;

/**
 * 71. 简化路径
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class SimplifyPath {

    /**
     * 29ms 56.68%
     * 46.4m 0.98%
     * 大家思路都一样
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> res = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (String pa : paths) {
            if (pa.equals("") || pa.equals("."))
                continue;
            if (pa.equals("..")) {
                if (!res.isEmpty())
                    res.removeLast();
            } else
                res.add(pa);
        }

        if (res.isEmpty()) return "/";

        while (!res.isEmpty()) {
            ans.append("/");
            ans.append(res.removeFirst());
        }

        return ans.toString();
    }
}
