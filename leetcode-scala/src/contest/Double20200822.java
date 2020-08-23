package contest;

import java.util.*;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/22 22:30
 * @Description Double20200822
 */
public class Double20200822 {

    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        int step = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 10);
            n /= 10;
            step++;
            step = step == 3 ? 0 : step;
            if (step == 0 && n != 0) {
                sb.append('.');
            }
        }

        return sb.reverse().toString();
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> froms = new HashSet<>();
        Set<Integer> tos = new HashSet<>();
        for (List<Integer> pair : edges) {
            froms.add(pair.get(0));
            tos.add(pair.get(1));
        }
        froms.removeAll(tos);

        return new ArrayList<>(froms);
    }

    Map<Integer, List<Integer>> mem = new HashMap<>();
    public int minOperations(int[] nums) {
        List<List<Integer>> pairs = new ArrayList<>(nums.length);
        for (int num : nums) pairs.add(helper(num));
        int maxDiv = 0;
        int sumSub = 0;
        for (List<Integer> pair : pairs) {
            maxDiv = Math.max(maxDiv, pair.get(0));
            sumSub += pair.get(1);
        }

        return maxDiv + sumSub;
    }

    private List<Integer> helper(int num) {
        if (mem.containsKey(num)) return mem.get(num);

        int origin = num;
        int div = 0;
        int sub = 0;
        while (num != 0) {
            if (mem.containsKey(num)) {
                List<Integer> me = mem.get(num);
                mem.put(origin, Arrays.asList(me.get(0) + div, me.get(1) + sub));
                return mem.get(origin);
            } else {
                if (num % 2 == 1) {
                    sub++;
                    num--;
                } else {
                    div++;
                    num /= 2;
                }
            }
        }
        mem.put(origin, Arrays.asList(div, sub));

        return mem.get(origin);
    }


    public boolean containsCycle(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Character.isUpperCase(grid[i][j])) continue;
                char origin = grid[i][j];
                if (dfs(grid, i, j, origin, 1)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, char origin, int step) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length
                || (Character.isLowerCase(grid[x][y]) && grid[x][y] != origin)
                || (Character.isUpperCase(grid[x][y]) && grid[x][y] != Character.toUpperCase(origin))) {
            return false;
        }
        if (grid[x][y] == Character.toUpperCase(origin) && step >= 4) {
            return true;
        }
        grid[x][y] = Character.toUpperCase(origin);

        return dfs(grid, x + 1, y, origin, step + 1)
                || dfs(grid, x - 1, y, origin, step + 1)
                || dfs(grid, x, y + 1, origin, step + 1)
                || dfs(grid, x, y - 1, origin, step + 1);
    }


    public static void main(String[] args) {
        System.out.println(new Double20200822().containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));

        String a = "123, 456";
        String[] pairs = a.split(" ");
        System.out.println(Integer.parseInt(pairs[0]) + Integer.parseInt(pairs[1]));
    }
}
