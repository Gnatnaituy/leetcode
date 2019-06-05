package java.classify.math;

public class ConvertANumberToHexadecimal {

    /**
     * 0ms 100.00%
     * 33MB 100.00%
     */
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.insert(0, map[(num & 15)]);
            num = (num >>> 4);
        }

        return result.toString();
    }
}
