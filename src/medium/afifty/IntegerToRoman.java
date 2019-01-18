package medium.afifty;

/**
 * 12. Integer to Roman
 */

public class IntegerToRoman {

        private String intToRoman(int num) {
            int[] digit = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            int cur = 12;
            StringBuilder res = new StringBuilder();
            
            while (num > 0) {
                while (num >= digit[cur]) {
                    num -= digit[cur];
                    res.append(roman[cur]);
                }
                cur--;
            }
            
            return res.toString();
        }
}
