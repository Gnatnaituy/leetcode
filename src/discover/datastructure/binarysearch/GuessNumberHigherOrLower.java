package discover.datastructure.binarysearch;


/**
 * 374 猜数字大小
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        if (guess(n) == 0) return n;

        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int t = guess(mid);
            if (t == 0) return mid;
            else if (t == 1) left = mid;
            else right = mid;
        }

        return left;
    }

    private int guess(int num) {
        return 1;
    }
}
