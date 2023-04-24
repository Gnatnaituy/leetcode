#
# @lc app=leetcode.cn id=1046 lang=python3
#
# [1046] 最后一块石头的重量
#

# @lc code=start
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort()
        while len(stones) > 2:
            diff = stones[-1] - stones[-2]
            if (diff == 0):
                stones = stones[0:-2]
            else:
                stones = stones[0:-2] + [diff]
                stones.sort()

        return stones[0] if len(stones) == 1 else stones[1] - stones[0]
# @lc code=end