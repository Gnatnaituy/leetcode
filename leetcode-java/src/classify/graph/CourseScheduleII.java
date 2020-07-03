package classify.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    /**
     * 3ms 98.42%
     * 43.7MB 92.30%
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                res[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : graph[cur]) {
                if (--degree[neighbor] == 0) {
                    queue.offer(neighbor);
                    res[index++] = neighbor;
                }
            }
        }

        return index == numCourses ? res : new int[0];
    }
}
