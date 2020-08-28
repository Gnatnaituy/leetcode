package dp.easy

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/28 14:34
 * @Description MinCostClimbingStairs
 */
object MinCostClimbingStairs {

    def minCostClimbingStairs(cost: Array[Int]): Int = {
        var prevvCost = 0
        var prevCost = 0
        var current = 0
        cost.foreach(c => {
            current = c + Math.min(prevvCost, prevCost)
            prevvCost = prevCost
            prevCost = current
        })

        Math.min(prevCost, prevvCost)
    }
}
