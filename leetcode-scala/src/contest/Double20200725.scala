package contest

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/25 22:44
 * @Description One
 */
object Double20200725 {

    def countOdds(low: Int, high: Int): Int = {
        ((high + 1) / 2 - (low + 1) / 2) + low % 2
    }

    def numOfSubarrays(arr: Array[Int]): Int = {
        val jishu = Array.fill(arr.length)(0)
        val oushu = Array.fill(arr.length)(0)
        jishu(0) = arr(0) % 2
        oushu(0) = (arr(0) + 1) % 2
        Array.range(1, arr.length).foreach(index => {
            if (arr(index) % 2 == 1) {
                jishu(index) = oushu(index - 1) + 1
                oushu(index) = jishu(index - 1)
            } else {
                jishu(index) = jishu(index - 1)
                oushu(index) = oushu(index - 1) + 1
            }
        })

        var res = 0
        jishu.foreach(e => res = (res + e) % 1000000007)

        res
    }
}
