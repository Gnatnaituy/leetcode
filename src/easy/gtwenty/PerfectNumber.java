package easy.gtwenty;


/**
 * 507 Perfect Number
 *
 * We define the Perfect Number is a positive integer that
 * is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n,
 * write a function that returns true when it is a perfect number and false when it is not.
 *
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 *
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */

public class PerfectNumber {

    private static boolean checkPerfectNumber(int num) {

        // 798 ms lol.....
//        ArrayList<Integer> factors = new ArrayList<>();
//
//        if (num == 0 || num == 1)
//            return false;
//
//        factors.add(1);
//        int start = 2; int end = num;
//        while (start < end) {
//            if (num % start == 0) {
//                factors.add(start);
//                if (start != num / start) factors.add(num / start);
//                end = num / start;
//            }
//            start++;
//        }
//
//        int sum = 0;
//        for (Integer i : factors) {
//            System.out.print(i + " ");
//            sum += i;
//        }
//
//        return sum == num;

        if (num < 2) return false;
        int n = (int) Math.sqrt(num);
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if (num % i == 0) res += i + num / i;
        }

        return res == num;
    }
}
