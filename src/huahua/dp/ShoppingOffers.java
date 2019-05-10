package huahua.dp;

import java.util.List;

public class ShoppingOffers {

    /**
     * 6ms 83.18%
     * 39.6MB 65.38%
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        int len = price.size();

        for (int i = 0; i < len; i++) res += needs.get(i) * price.get(i);

        for (List<Integer> list : special) {
            if (qualify(list, needs)) {
                for (int i = 0; i < len; i++) needs.set(i, needs.get(i) - list.get(i));
                int temp = helper(price, special, needs);
                res = Math.min(res, temp + list.get(len));
                for (int i = 0; i < len; i++) needs.set(i, needs.get(i) + list.get(i));
            }
        }

        return res;
    }

    private boolean qualify(List<Integer> list, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (list.get(i) > needs.get(i))
                return false;
        }

        return true;
    }
}
