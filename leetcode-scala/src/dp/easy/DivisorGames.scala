package dp.easy

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/28 16:54
 * @Description DivisorGames
 */
object DivisorGames {

    val mem = new Array[Int](1000)
    mem(1) = -1
    mem(2) = 1

    def divisorGame(N: Int): Boolean = {
        if (mem(N) != 0) return mem(N) == 1

        var res = false
        Array.range(1, N / 2 + 1).foreach(choice => {
            if (N % choice == 0) {
                if (mem(N - choice) == 0) mem(N - choice) = if (divisorGame(N - choice)) 1 else -1
                // 当前先手，如果对手（下一个状态值）为false，则说明我们可以赢
                if (mem(N - choice) == -1) {
                    res = true
                }
                res = res | mem(N - choice) == 1
            }
        })

        res
    }

    def main(args: Array[String]): Unit = {
        DivisorGames.divisorGame(5)
    }
}
