#
# @lc app=leetcode.cn id=892 lang=python3
#
# [892] 三维形体的表面积
#

# @lc code=start
class Solution:
    
    # 48ms      89.57%      O(n)
    # 15.1MB    37.39%      O(n)
    def surfaceArea2(self, grid: List[List[int]]) -> int:
        n = len(grid)
        res = 0
        for row in range(n):
            for col in range(n):
                # 前后
                if grid[row][col] != 0:
                    res += 2
                # 上
                if row == 0:
                    res += grid[row][col]
                else:
                    res += max(0, grid[row][col] - grid[row - 1][col])
                # 下
                if row == n - 1:
                    res += grid[row][col]
                else:
                    res += max(0, grid[row][col] - grid[row + 1][col])
                # 左
                if col == 0 :
                    res += grid[row][col]
                else:
                    res += max(0, grid[row][col] - grid[row][col - 1])
                # 右
                if col == n - 1:
                    res += grid[row][col]
                else:
                    res += max(0, grid[row][col] - grid[row][col + 1])
        
        return res    

    # 44ms      94.78%      O(n)
    # 15.1MB    38.26%      O(n)
    # 每个盒子6个面，每次接触少两个面
    # 盒子个数x6 - 接触面x2
    def surfaceArea(self, grid: List[List[int]]) -> int:
        n = len(grid)
        cube = overlap = 0
        for row in range(n):
            for col in range(n):
                high = grid[row][col]
                if high > 0:
                    cube += high
                    overlap += high - 1
                    if col < n - 1:
                        overlap += min(high, grid[row][col + 1])
                    if row < n - 1:
                        overlap += min(high, grid[row + 1][col])
        return cube * 6 - overlap * 2
# @lc code=end

