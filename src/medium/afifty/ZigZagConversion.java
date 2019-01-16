package medium.afifty;

/**
 * 6. ZigZag Conversion
 */

public class ZigZagConversion {

    private String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int gap = numRows * 2 - 2;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                res.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    int addition = index + (numRows - i - 1) * 2;
                    if (addition < s.length()) {
                        res.append(s.charAt(addition));
                    }
                }
                index += gap;
            }
            
        }
        
        return res.toString();
    }
}
