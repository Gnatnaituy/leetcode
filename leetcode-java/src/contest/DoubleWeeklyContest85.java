package contest;

public class DoubleWeeklyContest85 {

    public int minimumRecolors(String blocks, int k) {
        int cur = 0, count = 0, maxCount = 0;
        while (cur < blocks.length() && maxCount < k) {
            if (blocks.charAt(cur) == 'B') {
                count++;
            }
            if (cur >= k && blocks.charAt(cur - k) == 'B') {
                count--;
            }
            maxCount = Math.max(count, maxCount);
            cur++;
        }

        return k - maxCount;
    }

    public int secondsToRemoveOccurrences(String s) {
        int firstZeroIndex = -1, zeroCount = 0, continueZero = 0;
        int lastOneIndex = -1, oneCount = 0, continueOne = 0;
        boolean firstContinueZero = true, lastContinueOne = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && i < s.length() && s.charAt(i + 1) == '0') {
                while (s.charAt(i) == '0' && i < s.length()) {
                    continueZero++;
                    i++;
                }
                if (i == s.length()) {
                    continueZero = 0;
                } else {
                    continueZero--;
                }
                break;
            } 
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                oneCount++;
                if (lastOneIndex == -1) {
                    lastOneIndex = i;
                }
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1' && i > 0 && s.charAt(i - 1) == '1') {
                while (s.charAt(i) == '1' && i >= 0) {
                    continueOne++;
                    i--;
                }
                if (i == -1) {
                    continueOne = 0;
                } else {
                    continueOne--;
                }
                break;
            } 
        }

        System.out.printf("%s:%s:%s:%s\n", s.length(), firstZeroIndex, continueZero, zeroCount);
        System.out.printf("%s:%s:%s:%s\n", s.length(), lastOneIndex, continueOne, oneCount);
        return Math.max(s.length() - zeroCount - firstZeroIndex + (firstContinueZero ? 0 : continueZero), 
            lastOneIndex - oneCount + 1 + (lastContinueOne ? 0 : continueOne));
    }
    
    public static void main(String[] args) {
        DoubleWeeklyContest85 a = new DoubleWeeklyContest85();
        System.out.println(a.minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(a.secondsToRemoveOccurrences("00010000111001110101101101100010111010000011011101"));
    }
}
