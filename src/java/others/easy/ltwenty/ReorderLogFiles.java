package java.others.easy.ltwenty;

import java.util.*;

/**
 * 937 Reorder Log Files
 */

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        // 83ms 6.95% lol.....
//        List<String> letterLog = new ArrayList<>();
//        List<String> numberLog = new ArrayList<>();
//
//        for (String log : logs) {
//            String[] lo = log.split(" ", 2);
//            if (Character.isDigit(lo[1].charAt(0))) {
//                numberLog.add(log);
//            } else {
//                letterLog.add(log);
//            }
//        }
//
//        letterLog.sort((o1, o2) -> {
//            String a = o1.split(" ", 2)[1];
//            String b = o2.split(" ", 2)[1];
//            return a.compareTo(b);
//        });
//
//        String[] res = new String[logs.length];
//        for (int i = 0; i < letterLog.size(); i++) {
//            res[i] = letterLog.get(i);
//        }
//        for (int i = letterLog.size(); i < logs.length; i++) {
//            res[i] = numberLog.get(i - letterLog.size());
//        }
//
//        return res;
    
        // network influence speed
        ArrayList<String> digits = new ArrayList<>();
        ArrayList<String> letters = new ArrayList<>();
    
        for (String str : logs) {
            int index = str.indexOf(' ');
            char c = str.charAt(index + 1);
            if (c >= '0' && c <= '9') {
                digits.add(str);
            } else {
                letters.add(str);
            }
        }
        
        letters.sort((o1, o2) -> {
            int index1 = o1.indexOf(' ');
            int index2 = o2.indexOf(' ');
            while (index1 < o1.length() && index2 < o2.length()) {
                char c1 = o1.charAt(index1++);
                char c2 = o2.charAt(index2++);
                if (c1 > c2) {
                    return 1;
                } else if (c1 < c2) {
                    return -1;
                }
            }
            if (index1 < o1.length()) {
                return 1;
            } else if (index2 < o2.length()) {
                return -1;
            }
            return 0;
        });
        
        String[] rst = new String[logs.length];
        int index = 0;
        for (String letter : letters) {
            rst[index++] = letter;
        }
        for (String digit : digits) {
            rst[index++] = digit;
        }
        
        return rst;
    }
}
