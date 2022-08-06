package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoubleWeeklyContest84 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> valueWeights = new HashMap<>();
        for (int[] item : items1) {
            valueWeights.put(item[0], valueWeights.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            valueWeights.put(item[0], valueWeights.getOrDefault(item[0], 0) + item[1]);
        }

        return valueWeights.entrySet().stream()
        .sorted(Comparator.comparingInt(o -> o.getKey()))
        .map(item -> {
            return Arrays.asList(item.getKey(), item.getValue());
        }).collect(Collectors.toList());
    }

    public long countBadPairs(int[] nums) {
        long count = 0, total = 0;
        int row = 0, col = 0, maxCol = 0, length = nums.length;
        while (row < nums.length && maxCol < nums.length) {
            for (int i = Math.max(row + 1, maxCol); i < length; i++) {
                if (nums[i] - nums[row] == i - row) {
                    col = i;
                    count++;
                }
            }
            if (count > 0) {
                total += sum(count);
                count = 0;
                maxCol = col + 1;
            } else {
                row += 1;
            }
            col = 0;
        }

        return sum((long) nums.length - 1) - total;
    }

    public long sum(Long res) {
        return (res + 1) * (res / 2) + (res + 1) / 2 * (res % 2);
    }

    public long countBadPairs1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == nums[j] - nums[i]) {
                    System.out.println(i + ":" + j);
                }
            }
        }

        return res;
    }


    public long taskSchedulerII(int[] tasks, int space) {
        long day = 0;
        int index = 0;
        Map<Integer, Long> tasKPreDay = new HashMap<>();
        while (index < tasks.length) {
            Long preDay = tasKPreDay.get(tasks[index]);
            if (preDay == null || preDay + space < day) {
                tasKPreDay.put(tasks[index], day);
                day++;
            } else {
                tasKPreDay.put(tasks[index], preDay + space + 1);
                day = preDay + space + 2;
            }
            index++;
        }

        return day;
    }

    public static void main(String[] args) {
        DoubleWeeklyContest84 a = new DoubleWeeklyContest84();
        System.out.println(a.countBadPairs(new int[]{56,30,2,73,28,81,75,75,18,63,54,10,69,85,33,89,12,78,57,60,54,65,74,63,53,77}));
    }
}
