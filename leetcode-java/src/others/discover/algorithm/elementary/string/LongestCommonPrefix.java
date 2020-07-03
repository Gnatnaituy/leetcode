package others.discover.algorithm.elementary.string;

public class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀
     * 如果不存在公共前缀，返回空字符串 ""
     */
    public String longestCommonPrefix(String[] strs) {
        /*
        10ms 65.67%
         */
        if (strs.length == 0) {
            return "";
        } else {
            StringBuilder result = new StringBuilder(strs[0]);
            for (String str : strs) {
                result = commonPrefixOfTwoString(result, str);
            }

            return result.toString();
        }
    }

    private static StringBuilder commonPrefixOfTwoString(StringBuilder s1, String s2) {
        int i = 0;
        StringBuilder resultString = new StringBuilder();

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                resultString.append(s1.charAt(i));
                i++;
            } else break;
        }

        return resultString;
    }

    public String longestCommonPrefix2(String[] strs) {
        /*
        7ms
         */
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}
