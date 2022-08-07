package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WeeklyContest305 {

    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums.length < 3) return 0;
 
        int res = 0, leftDiff, rightDiff;
        for (int middle = 1; middle < nums.length - 1; middle++) {
            int left = middle - 1, right = middle + 1;
            while (left >= 0 && right < nums.length) {
                leftDiff = nums[middle] - nums[left];
                rightDiff = nums[right] - nums[middle];
                if (leftDiff == diff && rightDiff == diff) {
                    res++;
                    break;
                }
                if (leftDiff > diff || rightDiff > diff) {
                    break;
                }
                if (leftDiff < diff) left--;
                if (rightDiff < diff) right++;
            }
        }

        return res;
    } 

    /**
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int temp;
        for (int[] edge : edges) {
            if (edge[0] > edge[1]) {
                temp = edge[0];
                edge[0] = edge[1];
                edge[1] = temp;
            }
        }

        Set<Integer> restrictedNode = new HashSet<>();
        for (int a: restricted) restrictedNode.add(a);
    
        List<int[]> sortedEdges = Arrays.asList(edges).stream()
        .sorted(Comparator.comparingInt(o -> o[0]))
        .collect(Collectors.toList());

        Set<Integer> arrived = new HashSet<>();
        arrived.add(0);

        for (int[] edge : sortedEdges) {
            if (edge[0] == 0) {
                if (!restrictedNode.contains(edge[1])) arrived.add(edge[1]);
            } else {
                if ((arrived.contains(edge[0]) || arrived.contains(edge[1]))
                    && (!restrictedNode.contains(edge[0]) && !restrictedNode.contains(edge[1]))) {
                        arrived.add(edge[0]);
                        arrived.add(edge[1]);
                    }
            }
        }

        return arrived.size();
    }

    public static void main(String[] args) {
        WeeklyContest305 a = new WeeklyContest305();
        a.reachableNodes(4, new int[][]{{1,2},{1,0},{0,3}}, new int[]{2,3});
        System.out.println(1);
    }
}
