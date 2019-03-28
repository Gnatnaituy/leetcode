package methodstudy;

public class GreedyAlgorithm {

    /**
     * 事例一：找零钱问题
     * <p>
     * 假设你开了间小店，不能电子支付，钱柜里的货币只有 25 分、10 分、5 分和 1 分四种硬币，
     * 如果你是售货员且要找给客户 41 分钱的硬币，如何安排才能找给客人的钱既正确且硬币的个数又最少？
     * <p>
     * 这里需要明确的几个点：
     * 1.货币只有 25 分、10 分、5 分和 1 分四种硬币；
     * 2.找给客户 41 分钱的硬币；
     * 3.硬币最少化
     */
    private static void change(int amount) {
        int num25 = 0;
        int num10 = 0;
        int num05 = 0;
        int num01 = 0;

        while (amount >= 25) {
            amount -= 25;
            num25++;
        }
        while (amount >= 10) {
            amount -= 10;
            num10++;
        }
        while (amount >= 5) {
            amount -= 5;
            num05++;
        }
        while (amount >= 1) {
            amount -= 1;
            num01++;
        }

        System.out.println("25分硬币数: " + num25);
        System.out.println("10分硬币数: " + num10);
        System.out.println("5分硬币数:  " + num05);
        System.out.println("1分硬币数:  " + num01);
    }


    /**
     * 事例二:背包最大价值问题
     * <p>
     * 有一个背包，最多能承载重量为 C=150的物品，
     * 现在有7个物品（物品不能分割成任意大小），编号为 1~7，
     * 重量分别是 wi=[35,30,60,50,40,10,25]，
     * 价值分别是 pi=[10,40,30,50,35,40,30]，
     * 现在从这 7 个物品中选择一个或多个装入背包，要求在物品总重量不超过 C 的前提下，所装入的物品总价值最高。
     * <p>
     * 这里需要明确的几个点：
     * 1.每个物品都有重量和价值两个属性；
     * 2.每个物品分被选中和不被选中两个状态（后面还有个问题，待讨论）
     * 3.可选物品列表已知，背包总的承重量一定
     */
    private static void packageProblem() {
        class Target {
            int weight;
            int price;
            int status;
        }
    }


    public static void main(String[] args) {
        change(196);
    }
}
