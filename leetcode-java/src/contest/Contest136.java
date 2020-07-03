package contest;

import java.util.*;

public class Contest136 {

    public boolean isRobotBounded(String instructions) {
        int dir = 0;
        int g = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'R') dir = (dir + 1) % 4;
            if (c == 'L') dir = (dir + 3) % 4;
            if (c == 'G') {
                if (dir == 0 || dir == 1) g++;
                else g--;
            }
        }

        return g == 0 || dir != 0;
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        HashSet<int[]> set = new HashSet<>();
        int[] res = new int[N];

        Collections.addAll(set, paths);

        for (int i = 0; i < N; i++) {
            int type = 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(new int[]{i + 1, j + 1}) || set.contains(new int[]{j + 1 ,i + 1}))
                    type++;

            }
            res[i] = type;
        }

        return res;
    }

    public static void main(String[] args) {
        Map<int[], Integer> map= new HashMap<>();
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1,2});
        map.put(new int[]{1,2}, 1);
        System.out.println(set.contains(new int[]{1,2}));
        System.out.println(map.containsKey(new int[]{1,2}));

    }
}
