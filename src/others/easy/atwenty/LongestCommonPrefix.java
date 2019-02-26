package others.easy.atwenty;

public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {
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
            }
            else
                break;
        }
        return resultString;
    }

    public static void main(String[] args) {
        String[] strs = {"asdfghjkl", "asder", "asdfgerw"};
        System.out.println(longestCommonPrefix(strs));
    }
}
