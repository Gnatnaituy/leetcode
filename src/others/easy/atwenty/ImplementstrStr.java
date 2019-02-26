package others.easy.atwenty;

public class ImplementstrStr {

    private static int strStr(String haystack, String needle) {

        int index = -1;

        if (needle.equals("")) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return index;
        } else {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int count = 0;
                    for (int j = 0; j < needle.length(); j++) {
                        if (i + j < haystack.length() && needle.charAt(j) == haystack.charAt(i + j))
                            count++;
                        else
                            break;
                    }
                    if (count == needle.length()) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issipi";
        int c = strStr(a, b);
        System.out.print(c);
    }
}
