package others.easy.etwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 412 Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

public class FizzBuzz {

    private static List<String> fizzBuzz(int n ) {
        List<String> result = new ArrayList<>(n + 1);

        // 6ms surpass 25.52% users
//        for (int i = 1; i <= n; i++) {
//            if (i % 3 == 0 && i % 5 == 0)
//                result.add("FizzBuzz");
//            else if (i % 3 == 0)
//                result.add("Fizz");
//            else if (i % 5 == 0)
//                result.add("Buzz");
//            else
//                result.add("" + i);
//        }
//        return result;

        // 7ms......
//        result.add("");
//        for (int i = 1; i < n + 1; i++)
//            result.add("" + i);
//        if (n > 2)
//            for (int i = 3; i <= n; i += 3) {
//                if (i % 5 != 0)
//                    result.set(i, "Fizz");
//            }
//        if (n > 4)
//            for (int i = 5; i <= n; i += 5){
//                if (i % 3 != 0)
//                    result.set(i, "Buzz");
//            }
//        if (n > 14)
//            for (int i = 15; i <= n; i += 15)
//                result.set(i, "FizzBuzz");
//
//            result.remove(0);
//
//        return result;

        return new java.util.AbstractList<String>() {
            @Override
            public String get(int index) {
                index++;
                if (index % 15 == 0) {
                    return "FizzBuzz";
                }
                if (index % 3 == 0) {
                    return "Fizz";
                }
                if (index % 5 == 0) {
                    return "Buzz";
                }
                return index + "";
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}
