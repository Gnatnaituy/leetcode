package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeeklyContest317 {

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num: nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }
    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> creatorViews = new HashMap<>();
        Map<String, List<Integer>> creatorIds = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            final int j = i;
            creatorViews.compute(creators[j], (key, value) -> {
                if (value == null) value = 0;
                value += views[j];
                return value;
            });
            creatorIds.compute(creators[j], (key, value) -> {
                if (value == null) value = new ArrayList<>();
                value.add(j);
                return value;
            });
        }

        List<Map.Entry<String, Integer>> sortedViews = creatorViews.entrySet().stream()
            .sorted((o1, o2) -> (o1.getValue() < o2.getValue() ? 1 : -1))
            .collect(Collectors.toList());
        
        List<List<String>> res = new ArrayList<>();
        int maxView = sortedViews.get(0).getValue();
        for (Map.Entry<String, Integer> view : sortedViews) {
            if (view.getValue() < maxView) break;
            if (view.getValue() == maxView) {
                List<Integer> aIds = creatorIds.get(view.getKey());
                aIds.sort((o1, o2) -> o1 - o2);
                String maxId = ids[aIds.get(0)];
                int maxIdView = views[aIds.get(0)];
                for (int i = 1; i < aIds.size(); i++) {
                    if (views[aIds.get(i)] > maxIdView) {
                        maxId = ids[aIds.get(i)];
                        maxIdView = views[aIds.get(i)];
                    }
                }
                res.add(Arrays.asList(view.getKey(), maxId));
            }
        }

        return res;
    }

    public long makeIntegerBeautiful(long n, int target) {
        char[] nStr = String.valueOf(n).toCharArray();
        int[] nInt = new int[nStr.length + 1];
        for (int i = 1; i < nInt.length; i++) {
            nInt[i] = nStr[i - 1] - 48;
        }

        if (n == target * (Math.pow(10, nStr.length))) return 0;
        if (n + 1 == target * (Math.pow(10, nStr.length))) return 1;

        for (int i = 1; i < nInt.length; i++) {
            if (nInt[i] > target) {
                nInt[target == 0 ? --i - 1 : i - 1]++;
                while (i < nInt.length) {
                    nInt[i] = 0;
                    i++;
                }
                break;
            } else {
               target -= nInt[i]; 
            }
        }

        long a = 0l;
        for (int e : nInt) {
            a = a * 10 + e;
        }

        return a - n;
    }

    public static void main(String[] args) {
        WeeklyContest317 a = new WeeklyContest317();
        System.out.println(a.makeIntegerBeautiful(60, 6));

        System.out.println(10 ^ 5);
    }
}
