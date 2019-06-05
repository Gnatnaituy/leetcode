package java.completefifties.l0300;


public class BulbSwitcher {

    /**
     * 暴力法 超出时间限制
     */
    public int bulbSwitch(int n) {
        boolean[] status = new boolean[n];
        if (n == 0 || n == 1) return n;

        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                status[j] = !status[j];
            }
        }

        for (boolean a : status) {
            if (a) res++;
        }

        return res;
    }

    /**
     * 初始有n个灯泡关闭
     * 第i轮的操作是每i个灯泡切换一次开关（开->闭，闭->开），即切换i的倍数位置的开关。
     * 求n轮后亮着的灯泡？
     * （1）第i轮时，被切换的灯泡位置是i的倍数。
     * （2）由（1）得出，对于第p个灯泡来说，只有其第“因子”轮才会切换，若其有q个因子，则最终被切换q次
     * 因为初始状态是关闭状态，那么因子数是奇数的灯泡最终是亮着的。
     * （3）只有平方数的因子个数不是成对出现，举例：4=1*4,2*2，其因子是1,2,4。
     * （4）那么题目最终转化为1~n里平方数的个数，进而转化为对n开平方根，向下取整即可。
     */
    public int bulbSwitcher2(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
}
