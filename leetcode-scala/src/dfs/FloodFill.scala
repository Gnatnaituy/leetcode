package dfs

/**
 * @package dfs
 * @author 余天堂
 * @create 2020/7/13 20:55
 * @description FloodFill
 */
object FloodFill {

    /**
     * 604 ms   100.00%
     * 53.2 MB  100.00%
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        val ROW = image.length
        val COL = image(0).length
        val COLOR = image(sr)(sc)

        if (COLOR == newColor) return image

        def dfs(row: Int, col: Int): Unit = {
            if (row < 0 || row >= ROW || col < 0 || col >= COL || image(row)(col) != COLOR) return
            image(row)(col) = newColor
            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)
        }

        dfs(sr, sc)

        image
    }




    def main(args: Array[String]): Unit = {
        val flood = Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1))
        floodFill(flood, 1, 1, 2)
        flood.foreach(row => row.foreach(print))
    }
}
