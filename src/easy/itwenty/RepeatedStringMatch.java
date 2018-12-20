package easy.itwenty;

/**
 * 686 Reapted String Match
 */


class RepeatedStringMatch {
    private int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int lenA = A.length();
        int lenB = B.length();
        for(int i = 0; i < lenB / lenA + 2; i++){
            String str = sb.append(A).toString();
            if(str.indexOf(B) != -1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        String A = "abd";
        String B = "cdabcdab";
        int a = repeatedStringMatch.repeatedStringMatch(A, B);
        System.out.print(a);
    }
}