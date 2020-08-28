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
        Array.range(N - 1, 0, -1).foreach(o => {
            if (N % o == 0) {
                if (mem(N - o) == 0) mem(N - o) = if (divisorGame(N - o)) 1 else -1
                res = res | mem(N - o) == 1
            }
        })

        res
    }

    def main(args: Array[String]): Unit = {
        DivisorGames.divisorGame(5)
    }
}
