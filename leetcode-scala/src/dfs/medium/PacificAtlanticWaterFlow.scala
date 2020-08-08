package dfs.medium

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/3 21:03
 * @Description PacificAtlanticWaterFlow
 */
object PacificAtlanticWaterFlow {

    def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
        if (matrix == null || matrix.length < 1 || matrix(0).length < 1) return null

        val row = matrix.length
        val col = matrix(0).length
        val mark = Array.fill(matrix.length)(Array.fill(matrix(0).length)('0'))

        def pacificDfs(mark: Array[Array[Char]], x: Int, y: Int): Unit = {
            if (x >= row || y >= col || mark(x)(y) == 'X'
                || (x + 1 < row && matrix(x)(y) > matrix(x + 1)(y))
                || (y + 1 < col && matrix(x)(y) > matrix(x)(y + 1))) return

            mark(x)(y) = if (mark(x)(y) == 'Y' || mark(x)(y) == 'Z') 'Z' else 'X'
            pacificDfs(mark, x + 1, y)
            pacificDfs(mark, x, y + 1)
        }

        def atlanticDfs(mark: Array[Array[Char]], x: Int, y: Int): Unit = {
            if (x < 0 || y < 0 || mark(x)(y) == 'Y'
                || (x > 0 && matrix(x)(y) > matrix(x - 1)(y))
                || (y > 0 && matrix(x)(y) > matrix(x)(y - 1))) return

            mark(x)(y) = if (mark(x)(y) == 'Y' || mark(x)(y) == 'Z') 'Z' else 'Y'
            atlanticDfs(mark, x - 1, y)
            atlanticDfs(mark, x, y - 1)
        }

        (0 until row).foreach(x => (0 until col).foreach(y => {
            pacificDfs(mark, x, 0)
            pacificDfs(mark, 0, y)
            atlanticDfs(mark, row - x - 1, col - 1)
            atlanticDfs(mark, row - 1, col - y - 1)
        }))

        var res = List[List[Int]]()
        (0 until row).foreach(x => (0 until col).foreach(y => if (mark(x)(y) == 'Z') res :+= List(x, y)))

        res
    }

    def main(args: Array[String]): Unit = {
        val matrix = Array(Array(1,2,2,3,5), Array(3,2,3,4,4), Array(2,4,5,3,1), Array(6,7,1,4,5), Array(5,1,1,2,4))
        pacificAtlantic(matrix)
    }
}
