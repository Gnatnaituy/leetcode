package java.completefifties.l0000;

/**
 * 10. Regular Expression Matching
 */

public class RegularExpressionMatching {
    
    private boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            if (p.length() % 2 == 1)
                return false;
            for (int i = 0; i < p.length(); i++) {
                if (i % 2 == 1 && p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        char sch = s.charAt(s.length() - 1);
        char pch = p.charAt(p.length() - 1);
        if (pch == '.') {
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        } else if (pch == '*') {
            boolean result = false;
            char pre = p.charAt(p.length() - 2);
            if (pre == '.') {
                for (int i = s.length(); i >= 0; i--) {
                    result = result || isMatch(s.substring(0, i), p.substring(0, p.length() - 2));
                }
            } else {
                int lastIndex = -1;
                for (int i = s.length() - 1; i >= 0 ; i--) {
                    if (pre != s.charAt(i)) {
                        lastIndex = i;
                        break;
                    }
                }
                for (int i = lastIndex; i < s.length(); i++) {
                    result = result || isMatch(s.substring(0, i + 1), p.substring(0, p.length() - 2));
                }
            }
            return result;
        } else if (pch == sch) {
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        } else {
            return false;
        }
    }
}
