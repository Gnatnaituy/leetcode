package array

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/15 20:36
 * @Description MergeIntervals
 */
object MergeIntervals {

    /**
     * 648ms    91.67%
     * 54.9MB   100.00%
     * @param intervals
     * @return
     */
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val sortedIntervals = intervals.sortBy(x => x(0))

        var merged = new Array[Array[Int]](0)
        sortedIntervals.foreach(interval => {
            if (merged.length == 0 || merged(merged.length - 1)(1) < interval(0)) {
                merged :+= interval
            } else {
                merged(merged.length - 1)(1) = math.max(merged(merged.length - 1)(1), interval(1))
            }
        })

        merged
    }
}
