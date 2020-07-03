package others.easy.etwenty;

/**
 * 405 Convert a Number to Hexadecimal
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer,
 * two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero,
 * it is represented by a single zero character '0';
 * otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 *
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 */

public class ConvertANumberToHexadecimal {

    private static String toHex(int num) {
        long longNum = num;
        StringBuilder result = new StringBuilder();
        if (num < 0) {
            longNum += 4294967295L + 1;
        }

        while (longNum / 16 > 0) {
            switch ((int) (longNum % 16)) {
                case 10:
                    result.append('a');
                    break;
                case 11:
                    result.append('b');
                    break;
                case 12:
                    result.append('c');
                    break;
                case 13:
                    result.append('d');
                    break;
                case 14:
                    result.append('e');
                    break;
                case 15:
                    result.append('f');
                    break;
                default:
                    result.append(longNum % 16);
                    break;
            }
            longNum /= 16;
        }

        switch ((int) longNum) {
            case 10:
                result.append('a');
                break;
            case 11:
                result.append('b');
                break;
            case 12:
                result.append('c');
                break;
            case 13:
                result.append('d');
                break;
            case 14:
                result.append('e');
                break;
            case 15:
                result.append('f');
                break;
            default:
                result.append(longNum);
        }

        return result.reverse().toString();
    }
}
