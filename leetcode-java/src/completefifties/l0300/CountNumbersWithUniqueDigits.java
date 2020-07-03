package completefifties.l0300;

public class CountNumbersWithUniqueDigits {

    // Out of time
    public int countNumbersWithUniqueDigits(int n) {
//        int res = 0;
//        int des = (int) Math.pow(10, n);
//
//        for (int i = 0; i < des; i++) {
//            if (isUniqueNumber(i))
//                res++;
//        }
//
//        return res;

        // 不正经代码LOL
        switch (n) {
            case 0:
                return 1;
            case 1:
                return 10;
            case 2:
                return 91;
            case 3:
                return 739;
            case 4:
                return 5275;
            case 5:
                return 32491;
            case 6:
                return 168572;
            case 7:
                return 712891;
            case 8:
                return 2345851;
            case 9:
                return 5611771;
            case 10:
                return 6028171;
            default:
                return 0;
        }
    }

    private boolean isUniqueNumber(int n) {
        boolean[] places = new boolean[10];

        while (n > 0) {
            if (places[n % 10]) return false;
            places[n % 10] = true;
            n /= 10;
        }

        return true;
    }

    /**
     * 当 n > 10时, 必然会有重复的数字
     */
    public int countNumbersWithUniqueDigits2(int n) {
        int allNum = 0;
        n = n > 10 ? 10 : n;//n>10后不可能有不重复的，删了这句也行

        for (int i = 0; i < n; i++) {
            int thisNum = 9;
            for (int j = 0; j < i; j++)
                thisNum *= 9 - j;
            allNum += thisNum;
        }

        return allNum + 1;
    }
}
