package array

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/31 10:40
 * @Description ContainerWithMostWater
 */
object ContainerWithMostWater {

    /**
     * 2284ms   6.67%
     * 52.7MB   10.00%
     * Violence algorithm
     * @param height
     * @return
     */
    def maxArea(height: Array[Int]): Int = {
        var res = 0
        Array.range(0, height.length).foreach(start => {
            Array.range(start + 1, height.length).foreach(end => {
                res = math.max(res, (end - start) * math.min(height(start), height(end)))
            })
        })

        res
    }

    /**
     * 584ms    100.00%
     * 51.5MB   50.00%
     * Double point
     * @param height
     * @return
     */
    def maxArea2(height: Array[Int]): Int = {
        var max = 0
        var high = 0
        var width = 0
        var start = 0
        var end = height.length - 1
        while (start < end) {
            width = end - start
            if (height(start) < height(end)) {
                high = height(start)
                start += 1
            } else {
                high = height(end)
                end -= 1
            }
            max = math.max(max, high * width)
        }

        max
    }
}
