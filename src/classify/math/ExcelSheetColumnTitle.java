package classify.math;

public class ExcelSheetColumnTitle {

    /**
     * 0ms 100.00%
     * 33.1MB 100.00%
     */
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n != 0) {
            res.append((char) ((n % 26 == 0) ? 90 : n % 26 + 64));
            n = n % 26 == 0 ? n / 26 - 1 : n / 26;
        }

        return res.reverse().toString();
    }
}
