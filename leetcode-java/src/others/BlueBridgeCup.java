package others;

public class BlueBridgeCup {
    private static int[] nums = new int[10] ;
    private static boolean[] visited = new boolean[10];

    public static void main(String[] args) {
        dfs(0);

        System.out.println(dp(30));
    }

    /**
     * 第一题
     */
    private static void dfs(int offset) {
        if (offset == 10) {
            long num = 0L;
            for (int i = 0; i < 10; i++) {
                num = num * 10 + nums[i];
            }
            long sqrt = (long) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                System.out.println(num);
                return;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (!visited[i]) {
                visited[i] = true;
                nums[offset] = i;
                dfs(offset + 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 激光样式
     */
    public static int dp(int num) {
        int[] dp = {1, 1};

        for (int i = 1; i < num; i++) {
            dp[1] = dp[0] + dp[1];
            dp[0] = dp[1] - dp[0];
        }

        return dp[0] + dp[1];
    }
}
