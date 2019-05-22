package classify.graph;

import java.util.ArrayList;

public class CourseSchedule {

    /**
     * 2ms 100.00%
     * 43.8MB 54.97%
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] net = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            net[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            net[prerequisite[0]].add(prerequisite[1]);
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (checked[i]) {
                continue;
            }
            visited[i] = true;
            if (findCircle(net, checked, visited, i)) {
                return false;
            }
            visited[i] = false;
        }

        return true;
    }

    //true means find a circle
    private boolean findCircle(ArrayList[] net, boolean[] checked, boolean[] visited, int index) {
        for (int i = 0; i < net[index].size(); i++) {
            int cur = (int) net[index].get(i);
            if (checked[cur]) {
                continue;
            }
            if (visited[cur]) {
                return true;
            }

            visited[cur] = true;
            if (findCircle(net, checked, visited, cur)) {
                return true;
            }
            visited[cur] = false;
            checked[cur] = true;
        }

        return false;
    }
}
