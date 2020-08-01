package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/30 21:44
 * @Description DecodeString
 */
object DecodeString {

    /**
     * 668 ms   14.29%
     * 53.4MB   100.00%
     * @param s
     * @return
     */
    def decodeString(s: String): String = {
        val stack = mutable.Stack[Char]()
        s.foreach(c => {
            stack.push(c)
            if (']'.equals(stack.top)) track(stack)
        })

        stack.toList.mkString("").reverse
    }

    def track(stack: mutable.Stack[Char]): Unit = {
        var elem = ""
        while (!stack.top.toString.matches("[0-9]+")) {
            if (stack.top.toString.matches("[a-zA-Z]+")) elem = stack.pop() + elem
            else stack.pop()
        }

        var digits = ""
        while (stack.nonEmpty && stack.top.toString.matches("[0-9]+"))
            digits = stack.pop() + digits

        for (_ <- 1 to digits.toInt) stack.pushAll(elem.toCharArray)
    }
}
