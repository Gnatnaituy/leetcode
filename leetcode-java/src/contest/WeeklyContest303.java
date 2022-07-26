package contest;

import java.util.HashSet;
import java.util.Set;

public class WeeklyContest303 {

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            } else {
                set.add(c);
            }
        }
        return 'a';
    }
    
    public int equalPairs(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += isPairs(grid, i, j) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean isPairs(int[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }

        return true;
    }
}
