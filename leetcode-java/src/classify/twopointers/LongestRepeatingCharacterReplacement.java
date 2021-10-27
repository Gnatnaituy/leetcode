package classify.twopointers;

/**
 * @author yutiantang
 * @create 2021/3/22 10:51 PM
 */
public class LongestRepeatingCharacterReplacement {

    private final int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int left = 0, right = 0, historyCharMax = 0;
        while (right < chars.length) {
            int index = chars[right] - 'A';
            map[index]++;
            // 当窗口右移过程中，只需要和新加入字符的总个数比较即可
            // 不用再去比较所有的字符个数的最大值
            historyCharMax = Math.max(historyCharMax, map[index]);
            // 如果当前窗口的大小，比历史窗口中出现次数最多的字母次数 + k 还大
            // 则证明 k 不足以将当前窗口全部替换成同一个字母
            // 所以窗口左移
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                // 窗口滑动，无需更新historyCharMax
                left++;
            }
            right++;
        }

        return chars.length - left;
    }
}
