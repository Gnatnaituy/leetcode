package huahua.dp;

public class DeleteAndEarn {

    /**
     * 1ms 100.00%
     * 37.6MB 64.56%
     * 鱼和熊掌不得兼得，拿了一个num[i],与num[i]相邻的都要舍弃掉；而且如果我拿了value,那么数组中所有的value我都可以拿到；
     * 为了方便计算舍弃与value相邻的元素,需要将原始数组做转化；
     * num[i]的最大值为10000,故定义一个10001的桶buckets，每个桶里装的值就是所有value的sum;
     * <p>
     * 先倒着想，对于最后一个桶，我只有两种选择，take或者skip：
     * 当我take时，能获取到的最大值为buckets[last]+skip(last-1)
     * 当我skip时，能获取的最大值为前last-1个桶能获取到的最大值，max(take(last-1),skip(last-1));
     * 最后结果即从take或skip里选出最大值；
     * <p>
     * 从头开始，我们遍历桶,从1号桶开始，如果我take了1号桶，1号桶的里值归我所有,拿了1号通，2号桶不能拿，因为与1号桶相邻；
     * <p>
     * 如果我不拿1号桶，那2号桶我便可以拿....
     * 对于第i号桶，如果我take该桶的值，那么我能获取到的最大值为:take(i)=buckets[i]+skip(i-1);
     * 对于第i号桶，如果我skip了，那么我能获取到的最大值为：skip(i)=max(take(i-1)+skip(i-1));
     * <p>
     * 遍历完成后，取takeI和skipI的最大值即为结果；
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 处理数据，转化为桶，同时记录下max值，减少遍历次数；
        int max = nums[0];
        int[] buckets = new int[10001];

        for (int num : nums) {
            max = Math.max(num, max);
            buckets[num] += num;
        }

        int takeSumMax = 0; // take第i号桶时，take掉i号桶，能获取的的最大值；
        int skipSumMax = 0; // skip第i号桶时，skip掉i号桶，能获取的最大值；

        for (int i = 1; i <= max; i++) {
            // take当前桶
            int takeI = skipSumMax + buckets[i];
            // skip当前桶
            int skipI = Math.max(takeSumMax, skipSumMax);
            // 更新值
            takeSumMax = takeI;
            skipSumMax = skipI;
        }

        return Math.max(takeSumMax, skipSumMax);
    }

}
