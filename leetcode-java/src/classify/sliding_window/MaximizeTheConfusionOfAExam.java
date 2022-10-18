package classify.sliding_window;

public class MaximizeTheConfusionOfAExam {

    /**
     * 21ms     11.04%
     * 42MB     31.20%
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxChar(answerKey, 'T', k), maxChar(answerKey, 'F', k));
    }
 
    private int maxChar(String str, Character c, int k) {
        int slow = 0, fast = 0, res = 0, diff = 0;
        while (fast < str.length()) {
            if (c != str.charAt(fast)) {
                if (diff == k) {
                    if (str.charAt(slow) != c) diff--;
                    slow++;
                } else {
                    diff++;
                    fast++;
                }
            } else {
                fast++;
            }
            res = Math.max(res, fast - slow);
        }
        return res;
    }
}
