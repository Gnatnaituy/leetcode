package classify.prefix;

import tools.ParseArray;

public class RangeSumQueryMutable {

    /**
     * 1128ms   5.00%
     * 69.1MB   58.92MB
     */
    private int[] prefix;

    public RangeSumQueryMutable(int[] nums) {
        this.prefix = new int[nums.length];

        if (nums.length > 0) {
            this.prefix[0] = nums[0];
        }

        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                this.prefix[i] = nums[i] + this.prefix[i - 1];
            }
        }
    }

    public void update(int index, int val) {
        int origin = index == 0 ? prefix[0] : prefix[index] - prefix[index - 1];
        int diff = val - origin;
        while (index < prefix.length) {
            prefix[index++] += diff;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        } else {
            return prefix[right] - prefix[left - 1];
        }
    }

    /**
     * 分块处理
     * 99ms     22.95%
     * 68.9MB   65.36%
     */
    static class RangeSumQueryMutable2 {

        private int[] sum; // sum[i]表示第i个块的元素和
        private int size; // 块的大小
        private int[] nums;

        public RangeSumQueryMutable2(int[] nums) {
            this.nums = nums;
            int len = nums.length;
            size = (int) Math.sqrt(len);
            sum = new int[(len + size - 1) / size]; // 向上取整
            for (int i = 0; i < len; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int block1 = left / size, index1 = left % size;
            int block2 = right / size, index2 = right % size;

            if (block1 == block2) { // 区间[left, right]在同一个块中
                int sum = 0;
                for (int i = index1; i <= index2; i++) {
                    sum += nums[block1 * size + i];
                }

                return sum;
            }

            int sum1 = 0;
            for (int i = index1; i < size; i++) {
                sum1 += nums[block1 * size + i];
            }

            int sum2 = 0;
            for (int i = block1 + 1; i < block2; i++) {
                sum2 += sum[i];
            }

            int sum3 = 0;
            for (int i = 0; i <= index2; i++) {
                sum2 += nums[block2 * size + i];
            }

            return sum1 + sum2 + sum3;
        }
    }

    /**
     * 线段树/Segment Tree
     * 86ms     43.45%
     * 70.8MB   29.33%
     */
    static class RangeSumQueryMutable3 {

        private int[] segmentTree;
        private int len;

        public RangeSumQueryMutable3(int[] nums) {
            len = nums.length;
            segmentTree = new int[len * 4];
            build(0, 0, len - 1, nums);
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, len - 1);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, 0, len - 1);
        }

        private void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                segmentTree[node] = nums[start];
            } else {
                int middle = start + (end - start) / 2;
                build(node * 2 + 1, start, middle, nums);
                build(node * 2 + 2, middle + 1, end, nums);
                segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
            }
        }

        private void change(int index, int val, int node, int start, int end) {
            if (start == end) { // 此时start == end == index
                segmentTree[node] = val;
                return;
            }

            int middle = start + (end - start) / 2;
            if (index <= middle) {
                change(index, val, node * 2 + 1, start, middle);
            } else {
                change(index, val, node * 2 + 2, middle + 1, end);
            }
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        private int range(int left, int right, int node, int start, int end) {
            if (left == start && right == end) {
                return segmentTree[node];
            }

            int middle = start + (end - start) / 2;
            if (right <= middle) {
                return range(left, right, node * 2 + 1, start, middle);
            } else if (left > middle) {
                return range(left, right, node * 2 + 2, middle + 1, end);
            } else {
                int leftVal = range(left, middle, node * 2 + 1, start, middle);
                int rightVal = range(middle + 1, right, node * 2 + 2, middle + 1, end);
                return leftVal + rightVal;
            }
        }
    }

    public static void main(String[] args) {
        RangeSumQueryMutable mutable = new RangeSumQueryMutable(ParseArray.parseArray("[1,3,5]"));
        int a = mutable.sumRange(0, 2);
        mutable.update(1, 2);
        int b = mutable.sumRange(0, 2);
        System.out.printf("a: %s, b: %s\n", a, b);
    }
}
