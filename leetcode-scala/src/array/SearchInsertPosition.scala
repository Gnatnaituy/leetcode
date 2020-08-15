package array

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/15 20:30
 * @Description SearchInsertPosition
 */
object SearchInsertPosition {

    /**
     * 564ms    77.63%
     * 51MB     57.14%
     * @param nums
     * @param target
     * @return
     */
    def searchInsert(nums: Array[Int], target: Int): Int = {
        var cur = 0
        for (e <- nums) {
            if (e >= target) return cur
            cur += 1
        }
        cur
    }
}
