package classify.dp;

public class DivisorGame {

    /**
     * 0ms      100.00%
     * 34.9MB   95.50%
     * @param n
     * @return
     */
    public boolean divisorGame(int n) {
        return (n & 1) == 0;
    }

    /**
     * 6ms      25.22%
     * 35.3MB   32.15%
     * @param n
     * @return
     */
    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }
}
