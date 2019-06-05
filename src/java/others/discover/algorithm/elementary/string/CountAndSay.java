package java.others.discover.algorithm.elementary.string;

public class CountAndSay {

    public String countAndSay(int n) {
        /*
        11ms 47.38%
         */
        StringBuilder result = new StringBuilder();
        StringBuilder tempResult = new StringBuilder("1");

        if (n == 1) {
            return "1";
        }
        for (int i = 1; i < n; i++) {
            int count = 0;
            int index = 0;
            char previousChar = tempResult.charAt(0);
            result = new StringBuilder();

            while (index < tempResult.length()) {
                if (tempResult.charAt(index) == previousChar) {
                    count++;
                    index++;
                } else {
                    result.append(count);
                    result.append(previousChar);
                    previousChar = tempResult.charAt(index);
                    count = 1;
                    index++;
                }
            }
            result.append(count);
            result.append(previousChar);

            tempResult = result;
        }

        return result.toString();
    }

    public String countAndSay2(int n) {
        /*
        2ms
         */
        if(n == 1) return "1";
        //递归调用，然后对字符串处理
        String str = countAndSay(n-1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length - 1;i++) {
            if (c[i] == c[i+1]) {
                count++;//计数增加
            } else {
                //s = s + count + c[i];//上面的*标记这里方便统一处理
                sb.append(count).append(c[i]);
                count = 1;//初始化
            }
        }

        return sb.toString();
    }
}
