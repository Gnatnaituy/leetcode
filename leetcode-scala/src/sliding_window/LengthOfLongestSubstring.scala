import scala.collection.mutable

object LengthOfLongestSubString {
    
    def lengthOfLongestSubstring(s: String): Int = {
        calculate(s.toList, 0, new mutable.ArrayBuffer[Char])
    }

    def calculate(s: List[Int], length: Int, buffer: mutable.ArrayBuffer[Char]): Int = {
        s match {
            case Nil => math.max(length, buffer.length)
            case c :: cs => {
                if (buffer.contains(c)) {
                    calculate(cs, math.max(length, buffer.length), buffer.dropWhile(_ != c).drop(1) += c)
                } else {
                    calculate(cs, length, buffer += c)
                }
            }
        }
    }

    def main(args: Array[String]): Unit = {
        print(lengthOfLongestSubstring("qwertyasdawecafdarqw"))
    }
}