package sliding_window

import scala.collection.mutable

object LengthOfLongestSubString {
    
    def lengthOfLongestSubstring(s: String): Int = {
        calculate(s.toList, 0, new mutable.ArrayBuffer[Char])
    }

    @scala.annotation.tailrec
    def calculate(s: List[Char], length: Int, buffer: mutable.ArrayBuffer[Char]): Int = {
        s match {
            case Nil => math.max(length, buffer.length)
            case c :: cs =>
                if (buffer.contains(c)) {
                    calculate(cs, math.max(length, buffer.length), buffer.dropWhile(_ != c).drop(1) += c)
                } else {
                    calculate(cs, length, buffer += c)
                }
        }
    }

    def main(): Unit = {
        print(lengthOfLongestSubstring("qwertyasdawecafdarqw"))
    }
}