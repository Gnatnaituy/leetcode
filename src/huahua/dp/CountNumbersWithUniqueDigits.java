package huahua.dp;

public class CountNumbersWithUniqueDigits {

    /**
     * 0ms 100.00%
     * 31.8MB 100.00%
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;

        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }

        return res;
    }
}