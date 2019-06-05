package java.classify.math;

public class CountPrimes {

    /**
     * 13ms 54.96%
     * 33.7MB 47.53%
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return res;
    }
}
