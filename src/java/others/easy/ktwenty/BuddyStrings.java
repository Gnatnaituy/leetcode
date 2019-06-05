package java.others.easy.ktwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 859 Buddy Strings
 */

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        List<Integer> list = new ArrayList<>();
        
        if(A.length() < 2 || B.length() < 2 || A.length() != B.length())
            return false;
            
        //获取位置相同数字不同的个数
        for (int i = 0; i < A.length(); i++) {
            if(c1[i] != c2[i]){
                list.add(i);
            }
        }
        
        
        //数字不同的位置只能有零个或者两个
        if(list.size() <= 2){
            if(list.size() == 0){
                //字符串要是相等 交换后相等则需要字符串之中有相同的字节
                for (int i = 0; i < c1.length; i++) {
                    char ch = A.charAt(i);
                    if (A.indexOf(ch) != A.lastIndexOf(ch))
                        return true;
                    else
                        return false;
                }
            }
            return c1[list.get(0)] == c2[list.get(1)] && c1[list.get(1)] == c2[list.get(0)];
        }
        
        return false;
    }
}
  