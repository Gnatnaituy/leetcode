package completefifties.l0300;

public class AdditiveNumber {

    /*
    思路：依次确定v1,v2以及v1+v2含多少位数字，再从num中取多少位字符，判断取出的值与v1+v2是否相等
    */
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        //处理前两个字符都为0的特殊情况
        if (num.charAt(0) == '0' && num.charAt(1) == '0') {
            for (int i = 2; i < num.length(); i++) {
                if (num.charAt(i) != '0')
                    return false;
            }

            return true;
        }

        for (int j = 1; j <= num.length() - 2; j++) {
            long v1 = Long.valueOf(num.substring(0, j));
            if (countOfNumber(v1) != j)
                break;//如果v1的首位为0且不等于0，则直接跳出循环

            for (int k = j + 1; k <= num.length() - 1; k++) {
                long v2 = Long.valueOf(num.substring(j, k));

                if (countOfNumber(v2) != k - j)
                    break;//如果v2的首位为0且不是k-j位数，则跳出v2的循环。并且下一次重选v1

                if (dfs(v1, v2, k, num))  //遍历字符串
                    return true;
            }
        }

        return false;
    }

    //index为v3的起始位置
    private boolean dfs(long v1, long v2, int index, String num) {
        if (index == num.length())
            return true;

        int count = countOfNumber(v1 + v2);//计算得到v3应该含有多少位字符
        if (index + count > num.length())
            return false;

        long v3 = Long.valueOf(num.substring(index, index + count));
        if (v1 + v2 == v3)
            return dfs(v2, v3, index + count, num);//循环遍历字符串
        else
            return false;
    }

    //计算一个数含多少位数字
    private int countOfNumber(long v) {
        if (v == 0)
            return 1;

        int count = 0;
        while (v > 0) {
            count++;
            v /= 10;
        }

        return count;
    }
}
