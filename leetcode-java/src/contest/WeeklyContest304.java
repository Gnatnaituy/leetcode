package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeeklyContest304 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur) {
                continue;
            }
            cur = nums[i];
            count++;
        }

        return count;
    }

    public int maximumGroups(int[] grades) {
        int len = grades.length, group = 0, count = 0, i = 0;
        while (count < len) {
            count += ++i;
            group++;
        }

        return count > len ? group - 1 : group;
    }


    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> nodeStepA = new HashMap<>();
        nodeStepA.put(node1, 0);
        boolean walkA = true;
        int stepA = 0;
        while (walkA) {
            if (walkA && edges[node1] != -1 && !nodeStepA.containsKey(edges[node1])) {
                nodeStepA.put(edges[node1], ++stepA);
                node1 = edges[node1];
            } else {
                walkA = false;
            }
        }

        Map<Integer, Integer> nodeStepB = new HashMap<>();
        nodeStepB.put(node2, 0);
        boolean walkB = true;
        int stepB = 0;
        while (walkB) {
            if (walkB && edges[node2] != -1 && !nodeStepB.containsKey(edges[node2])) {
                nodeStepB.put(edges[node2], ++stepB);
                node2 = edges[node2];
            } else {
                walkB = false;
            }
        }

        Set<Integer> walkedNodes = new HashSet<>();
        walkedNodes.addAll(nodeStepA.keySet());
        walkedNodes.retainAll(nodeStepB.keySet());

        int minDistenceNode = -1;
        if (walkedNodes.size() == 0) {
            return minDistenceNode;
        } else {
            int minDistence = Integer.MAX_VALUE, distence;
            for (int node : walkedNodes) {
                distence = nodeStepA.get(node) + nodeStepB.get(node);
                if (distence < minDistence) {
                    minDistenceNode = node;
                    minDistence = distence;
                }
            }

            return minDistenceNode;
        }
    }

    public static void main(String[] args) {
        WeeklyContest304 a = new WeeklyContest304();
        System.out.println(a.closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1}, 5, 6));
    }
}
