package huahua.dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    private Map<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        if (n < 3) return 1;

        int res = 0;

        for (int i = 1; i < n; i++) {
            int temp;
            if (map.containsKey(n - i)) {
                temp = map.get(n - i);
            } else {
                temp = integerBreak(n - i) * i;
                map.put(n - i, temp / i);
            }
            res = Math.max(res, temp);
        }

        return res;
    }
}
