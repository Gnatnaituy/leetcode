package easy.ltwenty;

import java.util.HashSet;
import java.util.Set;

/**
 * 874 Walking Robot Simulation
 */

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, direction = 0, res = 0;
        Set<Long> obstacleSet = new HashSet<>();

        // encode obstacle (x, y) as (x + 30000) * (2 ^ 16) + (y + 30000)
        for (int[] obstacle : obstacles) {
            long lx = (long) obstacle[0] + 30000;
            long ly = (long) obstacle[1] + 30000;
            obstacleSet.add((lx << 16) + ly);
        }

        for (int cmd : commands) {
            if (cmd == -1)
                direction = (direction + 1) % 4;
            else if (cmd == -2)
                direction = (direction - 1 + 4) % 4;
            else {
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }

        return res;
    }
}