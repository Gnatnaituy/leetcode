#
# @lc app=leetcode.cn id=424 lang=python3
#
# [424] 替换后的最长重复字符
#

# @lc code=start
from typing import List


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len: int = 0
        str_len: int = len(s)
        fast: int = 0
        slow: int = 0
        char_distinct: int = 0
        char_count: List[int] = [26]

        while fast < str_len:
            if (char_count[ord(s[fast]) - 65] == 0):
                char_count[ord(s[fast]) - 65] = 1
                char_distinct += 1
            if (char_distinct > k):
                while char_count[ord(s[slow])] != 0:
                    char_count[ord(s[slow]) - 65] -= 1
                    slow += 1
                char_distinct -= 1
            max_len = max(max_len, fast - slow + 1)
            fast += 1

        return max_len

# @lc code=end

if __name__ == '__main__':
    print(ord('A'))