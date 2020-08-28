package dp.easy

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/28 11:25
 * @Description RangeSumQueryImmutable
 */
object RangeSumQueryImmutable {

    class NumArray(_nums: Array[Int]) {

        val nums: Array[Int] = _nums

        def sumRange(i: Int, j: Int): Int = {
            val sums = nums.scanLeft(0)(_ + _)
            sums(j + 1) - sums(i)
        }
    }

    def main(args: Array[String]): Unit = {
        println(new NumArray(Array.range(1, 10)).sumRange(0, 3))
    }
}
