package contest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class WeeklyContest318 {

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] += nums[i];
                nums[i + 1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                res[index++] = num;
            }
        }

        return res;
    }
    
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, maxSum = 0;
        Set<Integer> uniNums = new HashSet<>();

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (uniNums.contains(nums[fast])) {
                sum = nums[fast];
                uniNums.clear();
                uniNums.add(nums[fast]);
                slow = fast;
            } else {
                sum += nums[fast];
                uniNums.add(nums[fast]);
                if (fast - slow + 1 == k) {
                    maxSum = Math.max(maxSum, sum);
                    sum -= nums[slow];
                    uniNums.remove(nums[slow]);
                    slow++; 
                }
            } 
            fast++;
        }

        return maxSum;
    }

    public long totalCost(int[] costs, int k, int candidates) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.cost < o2.cost) {
                    return -1;
                } else if (o1.cost > o2.cost) {
                    return 1;
                } else {
                    return o1.index - o2.index;
                }
            }
        };
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);
        int left = 0, right = costs.length - 1;
        while (left < candidates && left <= right) {
            if (left == right) {
                queue.add(new Pair(costs[left], left));
            } else {
                queue.add(new Pair(costs[left], left));
                queue.add(new Pair(costs[right], right));
            }
            left++;
            right--;
        }

        long cost = 0;
        while (k > 0) {
            Pair o = queue.poll();
            System.out.println("cost: " + o.cost + " index: " + o.index);
            cost += o.cost;
            k--;
            if (left <= right) {
                if (o.index < left) {
                    queue.add(new Pair(costs[left], left));
                    left++;
                } else {
                    queue.add(new Pair(costs[right], right));
                    right--;
                }
            }
        }

        return cost;
    }

    static class Pair {
        int cost;
        int index;
        Pair (int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        WeeklyContest318 a = new WeeklyContest318();
        // System.out.println(a.maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));
        // System.out.println(a.maximumSubarraySum(new int[]{9,9,9,1,2,3}, 3));
        // System.out.println(a.maximumSubarraySum(new int[]{1,1,2}, 2));
        System.out.println(a.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
    }
}
