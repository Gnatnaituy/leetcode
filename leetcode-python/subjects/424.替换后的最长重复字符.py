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
        fast: int = 0
        slow: int = 0
        char_num: List[int] = [0] * 26

        while fast < len(s):
            char_num[ord(s[fast]) - 65] += 1
            max_len = max(max_len, char_num[ord(s[fast]) - 65])
            if fast - slow + 1 - max_len > k:
                char_num[ord(s[slow]) - 65] -= 1
                slow += 1
            fast += 1
            print('slow:', slow, 'fast:', fast)

        return fast - slow

# @lc code=end

if __name__ == '__main__':
    so = Solution()
    print(so.characterReplacement('ABABAAAB', 1))