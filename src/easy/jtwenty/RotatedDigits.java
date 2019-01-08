package easy.jtwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 788 Rotated Digits
 */

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) res++;
        }
        return res;
    }
    
    private boolean isGoodNumber(int num) {
        List<Integer> nums = new ArrayList<>();
        while (num != 0) {
            nums.add(num % 10);
            num /= 10;
        }
        return !(nums.contains(3) || nums.contains(4) || nums.contains(7))
                && (nums.contains(2) || nums.contains(5) || nums.contains(6) || nums.contains(9));
    }
}