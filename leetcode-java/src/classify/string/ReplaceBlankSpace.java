package classify.string;

public class ReplaceBlankSpace {

    /**
     * 0ms      100.00%
     * 36.1MB   73.87%
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
