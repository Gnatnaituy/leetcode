package completefifties.l0300;


public class BulbSwitcher {

    /**
     * 暴力法 超出时间限制
     */
    public int bulbSwitch(int n) {
        boolean[] status = new boolean[n];
        if (n == 0 || n == 1) return n;

        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                status[j] = !status[j];
            }
        }

        for (boolean a : status) {
            if (a) res++;
        }

        return res;
    }
}
