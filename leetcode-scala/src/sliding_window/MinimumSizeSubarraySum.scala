package sliding_window

object MinimumSizeSubarraySum {

  /**
   * 滑动窗口
   * 652ms 50.00%
   * 52.8MB 100.00%
   */
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0

    var (left, sum, len) = (0, 0, 0)

    for (right <- nums.indices) {
      sum += nums(right)
      while (sum >= s) {
        len = if (len == 0) right - left + 1 else math.min(len, right - left + 1)
        sum -= nums(left)
        left += 1
      }
    }

    len
  }

  def main(args: Array[String]): Unit = {
    print(minSubArrayLen(5, Array(1, 2, 3 ,4, 5)))
  }
}

