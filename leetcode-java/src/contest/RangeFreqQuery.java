package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tiantang
 * @Date 2021/11/21
 */
public class RangeFreqQuery {

    private Map<Integer, ArrayList<Integer>> stat = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> indexes;
            if (stat.containsKey(arr[i])) {
                indexes = stat.get(arr[i]);
            } else {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            stat.put(arr[i], indexes);
        }
        System.out.println("stat: " + stat.toString());
    }

    public int query(int left, int right, int value) {
        ArrayList<Integer> indexes = stat.get(value);
        if (indexes == null || indexes.size() == 0) {
            return 0;
        }


        int min = 0, max = indexes.size() - 1;

        System.out.println("indexes: " + indexes);
        int start = 0, end = indexes.size() - 1;
        if (indexes.get(start) < left) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (indexes.get(mid) > left) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }
        min = start;

        start = 0;
        end = indexes.size() - 1;
        if (indexes.get(end) > right) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (indexes.get(mid) > right) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }
        max = end;

        System.out.println("max: " + max + " min: " + min);
        return max - min + 1;
    }

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12,33,4,56,22,2,34,33,22,12,34,56});
        rangeFreqQuery.query(1 ,2, 4);
        rangeFreqQuery.query(0 ,11, 33);
    }
}
