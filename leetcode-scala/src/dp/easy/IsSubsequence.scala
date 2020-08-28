package dp.easy

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/28 13:51
 * @Description IsSubsequence
 */
object IsSubsequence {

    /**
     * 548 ms   5.00%
     * 50MB     71.43%
     * @param s
     * @param t
     * @return
     */
    def isSubsequence(s: String, t: String): Boolean = {
        if (s == null || s.length == 0) return true
        if (t == null || s.length > t.length) return false

        val c = s.charAt(0)
        val i = t.indexOf(c)
        i != -1 && isSubsequence(s.substring(1), t.substring(i + 1))
    }

    /**
     * 492ms    80.00%
     * 50.1MB   35.71%
     * @param s
     * @param t
     * @return
     */
    def isSubsequence2(s: String, t: String): Boolean = {
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s(i) == t(j)) {
                i += 1
            }
            j += 1
        }
        i >= s.length
    }
}
