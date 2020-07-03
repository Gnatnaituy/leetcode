package others.easy.itwenty;

/**
 * 696 Count Binary Substrings
 */

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int cnt = 0;
        int left = 0, right = 1, last_dis = 0;
        while(right < s.length()){
            if(s.charAt(right) != s.charAt(right - 1)) {
                cnt += Math.min(right - left, last_dis);
                last_dis = right - left;
                left = right;
            }
            right++;
        }
        cnt += Math.min(right - left, last_dis);
        return cnt;
    }
}