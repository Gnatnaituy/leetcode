package discover.algorithm.elementary.string;

public class ImplementStrStr {

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
     * 如果不存在，则返回  -1。
     */
    public int strStr(String haystack, String needle) {
        /*
        9ms 35.93%
         */
        if (needle.equals("")) return 0;

        for (int i = 0;  i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isRes = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isRes = false;
                        break;
                    }
                }
                if (isRes) return i;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        /*
        4ms
         */
        if (needle == null || needle.length() == 0) {
            return 0 ;
        }
        for (int i = 0 ; i <= (haystack.length() - needle.length()) ; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
