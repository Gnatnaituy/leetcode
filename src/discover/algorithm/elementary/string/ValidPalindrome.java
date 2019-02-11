package discover.algorithm.elementary.string;

public class ValidPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     */
    public boolean isPalindrome(String s) {
        /*
        17ms 36.13%
        去掉无用元素, 只保留数字和字母
        头尾双指针比较
        时间复杂度O(2n)
         */
         StringBuilder sb = new StringBuilder();
         for (char c : s.toLowerCase().toCharArray()) {
             if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                 sb.append(c);
             }
         }

         int left = 0, right = sb.length() - 1;
         while (left < right) {
             if (sb.charAt(left++) != sb.charAt(right--)) {
                 return false;
             }
         }

         return true;
    }

    public boolean isPalindrome2(String s) {
        /*
        2ms
        48 '0' 57 '9' 65 'A' 90 'Z' 97 'a' 122 'z'
         */
        int low = 0;
        int high = s.length() - 1;
        while (true) {
            if (low >= high) {
                return true;
            }

            int start = (int) s.charAt(low);
            // start is uppercase and change it to lowercase
            if (start >= 65 && start <= 90) {
                start += 32;
            }

            if ((start >= 97 && start <= 122) || (start >= 48 && start <= 57)) {
                int end = (int) s.charAt(high);
                // end is uppercase and change it to lowercase
                if (end >= 65 && end <= 90) {
                    end += 32;
                }

                if ((end >= 97 && end <= 122) || (end >= 48 && end <= 57)) {
                    if (start != end) {
                        return false;
                    } else {
                        low++;
                        high--;
                    }
                } else {
                    high--;
                }
            } else {
                low++;
            }
        }
    }
}
